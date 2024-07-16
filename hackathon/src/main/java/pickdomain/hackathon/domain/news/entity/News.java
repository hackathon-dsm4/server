package pickdomain.hackathon.domain.news.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.feed.entity.Type;

import javax.persistence.*;

@Entity
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
    @Enumerated(EnumType.STRING)
    private Type type;
}
