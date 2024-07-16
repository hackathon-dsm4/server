package pickdomain.hackathon.domain.feed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;
    private Type type;
    @Column(columnDefinition = "INT")
    private Integer like;

    public void addLike() {
        this.like += 1;
    }

    public void minusLike() {
        this.like -= 1;
    }
}
