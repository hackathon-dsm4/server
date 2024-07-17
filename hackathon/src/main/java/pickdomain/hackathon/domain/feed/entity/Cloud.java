package pickdomain.hackathon.domain.feed.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="cloud")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cloud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordId;

    @Column(nullable = false, length = 20)
    private String word;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int count;

    @Column(nullable = false)
    private LocalDateTime issueDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type kind;
}
