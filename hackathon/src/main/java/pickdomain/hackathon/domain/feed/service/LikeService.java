package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.entity.FeedLike;
import pickdomain.hackathon.domain.feed.entity.Notice;
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

    @Transactional
    public Integer execute(Long feedId) {
        Notice feed = feedRepository.findById(feedId).orElseThrow(() -> new RuntimeException());
        User user = userFacade.getCurrentUser();

        if (isAlreadyLiked(feed, user)) {
            likeRepository.deleteByUserAndFeed(user, feed);
            feed.minusLike();
            return feed.getCount();
        }

        likeRepository.save(
                FeedLike.builder()
                        .user(user)
                        .feed(feed)
                        .build()
        );
        feed.addLike();
        return feed.getCount();
    }

    private boolean isAlreadyLiked(Notice feed, User user) {
        return likeRepository.existsByUserAndFeed(user, feed);
    }
}
