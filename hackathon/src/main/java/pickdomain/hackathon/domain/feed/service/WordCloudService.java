package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.feed.entity.Cloud;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.feed.repository.CloudRepository;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordCloudService {
    private final NewsRepository newsRepository;
    private final CloudRepository wordRepository;


    public Map<String, Integer> generateWordCloud(LocalDateTime localDateTime, Type type) {

        String today = localDateTime.format(DateTimeFormatter.ISO_DATE);
        // 1. 뉴스 데이터 전체 가져오기
        List<News> newsEntities = newsRepository.findAllByPubDateContainingAndType(
                today,
                type
        );


        Map<String, Integer> wordFrequency = newsEntities.stream()
                .flatMap(news -> Arrays.stream(news.getDescription().split("\\s+")))
                .map(String::trim)
                .filter(word -> word.matches("[a-zA-Z가-힣]+") && !word.matches("[.]{3}|이나|이런"))
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum
                ));


        Map<String, Integer> topTenWords = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        topTenWords.forEach((word, frequency) -> {
            Cloud wordEntity = new Cloud();
            wordEntity.setWord(word);
            wordEntity.setCount(frequency);
            wordRepository.save(wordEntity);
        });

        return topTenWords;
    }
}
