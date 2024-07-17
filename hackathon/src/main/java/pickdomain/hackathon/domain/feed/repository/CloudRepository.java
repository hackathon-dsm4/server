package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Cloud;

public interface CloudRepository extends JpaRepository<Cloud, Long> {
}
