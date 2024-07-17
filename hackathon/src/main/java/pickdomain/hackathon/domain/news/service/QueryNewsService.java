package pickdomain.hackathon.domain.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.news.dto.QueryAllNewsResponse;
import pickdomain.hackathon.domain.news.dto.QueryNewsResponse;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryNewsService {
    private final NewsRepository newsRepository;
    private final FeedRepository feedRepository;

    public QueryNewsResponse execute(Long id) {
        News news = newsRepository.findById(id).orElse(null);
        List<Notice> notice = feedRepository.findAllByNews(news);

        return new QueryNewsResponse(
                 news.getTitle(), news.getOriginallink(), news.getDescription(), news.getPubDate(),news.getLink(),
                 news.getType(), notice.stream().map(it-> it.getContent()).collect(Collectors.toList())
        );
    }

    public List<QueryAllNewsResponse> all() {
        return newsRepository.findAll().stream()
                .map(it->
                        new QueryAllNewsResponse(
                                it.getTitle(), it.getType(), it.getJob(), it.getProfile(), it.getCount()
                        )
                ).sorted(Comparator.comparingInt(QueryAllNewsResponse::getCount).reversed())
                .collect(Collectors.toList());
    }
}
