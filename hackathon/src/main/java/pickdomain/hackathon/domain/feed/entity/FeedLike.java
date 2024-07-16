package pickdomain.hackathon.domain.feed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.user.entity.User;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class FeedLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
