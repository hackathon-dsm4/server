package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.user.entity.User;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    List<Feed> findByUser(User user);
}
