package pickdomain.hackathon.domain.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.news.entity.News;

import java.time.LocalDateTime;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByPubDateContainingAndType(String start, Type type);
}
