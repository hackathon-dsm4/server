package pickdomain.hackathon.domain.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.news.dto.QueryNewsResponse;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsRepository;

@Service
@RequiredArgsConstructor
public class QueryNewsService {
    private final NewsRepository newsRepository;

    public QueryNewsResponse execute(Long id) {
        News news = newsRepository.findById(id).orElse(null);
        return new QueryNewsResponse(
                news.getTitle(), news.getOriginallink(), news.getDescription(), news.getPubDate(),news.getLink(),
                 news.getType()
        );
    }
}
