package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.entity.FeedLike;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.repository.LikeRepository;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    public Integer execute(Long feedId) {
        Feed feed = feedRepository.findById(feedId).orElseThrow(()-> new RuntimeException());
        User user = userFacade.getCurrentUser();

        if (likeRepository.existsByUserAndFeed(user, feed)){
            likeRepository.deleteByUserAndFeed(user, feed);
            feed.minusLike();
            return feed.getLike();
        }
        likeRepository.save(
                FeedLike.builder()
                        .user(user)
                        .feed(feed)
                        .build()
        );
        feed.addLike();
        return feed.getLike();
    }
}
