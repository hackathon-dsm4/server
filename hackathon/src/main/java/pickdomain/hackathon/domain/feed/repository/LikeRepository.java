package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.FeedLike;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.user.entity.User;

import java.util.List;

public interface LikeRepository extends JpaRepository<FeedLike, Long> {
    boolean existsByUserAndFeed(User user, Notice feed);
    void deleteByUserAndFeed(User user, Notice feed);

    List<FeedLike> findByUser(User user);
}
