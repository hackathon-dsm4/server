package pickdomain.hackathon.domain.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.news.dto.QueryNewsResponse;
import pickdomain.hackathon.domain.news.repository.NewsRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryNewsService {
    private final NewsRepository newsRepository;

    public QueryNewsResponse queryNews() {
        return newsRepository.findAll()
                .stream()
                .map(QueryNewsResponse::new)
                .collect(Collectors.toList());
    }
}
