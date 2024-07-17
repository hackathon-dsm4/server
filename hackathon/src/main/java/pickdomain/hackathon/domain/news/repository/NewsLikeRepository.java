package pickdomain.hackathon.domain.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.entity.NewsLike;
import pickdomain.hackathon.domain.user.entity.User;

import java.util.List;

public interface NewsLikeRepository extends JpaRepository<NewsLike, Long> {
    boolean existsByUserAndNews(User user, News news);
    void deleteByUserAndNews(User user, News news);

    List<NewsLike> findByUser(User user);
}
