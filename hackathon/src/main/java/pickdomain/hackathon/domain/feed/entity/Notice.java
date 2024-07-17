package pickdomain.hackathon.domain.feed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.user.entity.User;

import javax.persistence.*;

@Entity(name = "Feed")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id", nullable = false)
    private News news;
    @Column(columnDefinition = "INT")
    private Integer count;

    public void addLike() {
        this.count += 1;
    }

    public void minusLike() {
        this.count -= 1;
    }
}