package pickdomain.hackathon.domain.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.user.entity.User;

import java.util.List;

public interface FeedRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByUser(User user);

    List<Notice> findAllByNews(News news);
}
