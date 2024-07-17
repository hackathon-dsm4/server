package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pickdomain.hackathon.domain.feed.entity.Cloud;
import pickdomain.hackathon.domain.feed.entity.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CloudRepository extends JpaRepository<Cloud, Long> {
    List<Cloud> findAllByIssueDateAndKind(LocalDate issueDate, Type kind);
}
