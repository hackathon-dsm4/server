package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.entity.Cloud;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.feed.presentation.dto.response.NoticeWordResponse;
import pickdomain.hackathon.domain.feed.repository.CloudRepository;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordNewsService {
    private final NewsRepository newsRepository;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", Locale.ENGLISH);

    @Transactional(readOnly = true)
    public List<NoticeWordResponse> asdf(LocalDate date, String type, String word) {
        String today = date.format(dateTimeFormatter);
        return  newsRepository.findAllByPubDateAndTypeAndDescription(
                Type.valueOf(type).name(),today, word
        ).stream()
                .map( it ->
                        NoticeWordResponse.noticeWordResponse(it, word)
                )
                .collect(Collectors.toList());
    }
}
