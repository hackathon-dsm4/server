package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}