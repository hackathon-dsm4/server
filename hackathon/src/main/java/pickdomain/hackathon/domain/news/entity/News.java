package pickdomain.hackathon.domain.news.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "news")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String originallink;
    private String description;
    private String pubDate;
    private String link;
    private String job;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(columnDefinition = "INT")
    private Integer count;
    @Column(columnDefinition = "TEXT")
    private String profile;
    @OneToMany(mappedBy = "news")
    private List<Notice> notices = new ArrayList<>();

    public void addLike() {
        this.count += 1;
    }

    public void minusLike() {
        this.count -= 1;
    }
}
