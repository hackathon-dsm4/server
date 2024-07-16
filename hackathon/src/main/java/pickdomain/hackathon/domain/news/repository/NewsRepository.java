package pickdomain.hackathon.domain.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.news.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
