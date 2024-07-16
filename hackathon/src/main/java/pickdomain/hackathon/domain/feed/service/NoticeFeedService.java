package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.domain.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.presentation.dto.request.NoticeFeedRequest;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsRepository;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@RequiredArgsConstructor
@Service
public class NoticeFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final NewsRepository newsRepository;

    @Transactional
    public void execute(NoticeFeedRequest noticeFeedRequest, Long id) {
        User user = userFacade.getCurrentUser();
        News news = newsRepository.findById(id).orElseThrow(()-> new RuntimeException());
        Feed feed = Feed.builder()
                .content(noticeFeedRequest.getContent())
                .userName(user.getName())
                .news(news)
                .build();
        feedRepository.save(feed);
    }
}