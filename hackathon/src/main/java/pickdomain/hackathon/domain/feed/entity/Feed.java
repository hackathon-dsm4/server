package pickdomain.hackathon.domain.feed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.news.entity.News;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    private String userName;
    @ManyToOne
    private News news;
    private Type type;
    private Integer like = 0;

    public void addLike() {
        this.like += 1;
    }

    public void minusLike() {
        this.like -= 1;
}
