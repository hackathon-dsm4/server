package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Cloud;
import pickdomain.hackathon.domain.feed.entity.Type;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CloudRepository extends JpaRepository<Cloud, Long> {
    Optional<List<Cloud>> findAllByIssueDateAndKind(LocalDateTime date, Type kind);
}
