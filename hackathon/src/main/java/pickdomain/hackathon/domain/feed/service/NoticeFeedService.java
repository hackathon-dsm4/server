package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
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
    public void execute(NoticeFeedRequest noticeFeedRequest) {
        User user = userFacade.getCurrentUser();
        News news = newsRepository.findById(noticeFeedRequest.getId()).orElseThrow(()-> new RuntimeException());
        Feed feed = Feed.builder()
                .content(noticeFeedRequest.getContent())
                .user(user)
                .news(news)
                .like(0)
                .build();
        feedRepository.save(feed);
    }
}