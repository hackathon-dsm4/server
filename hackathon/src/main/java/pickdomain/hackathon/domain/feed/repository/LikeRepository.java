package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.entity.FeedLike;
import pickdomain.hackathon.domain.user.entity.User;

public interface LikeRepository extends JpaRepository<FeedLike, Long> {
    boolean existsByUserAndFeed(User user, Feed feed);
    void deleteByUserAndFeed(User user, Feed feed);
}
