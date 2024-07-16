package pickdomain.hackathon.domain.dictionary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordId;

    @Column(nullable = false, length = 80)
    private String word;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String meaning;

    @Enumerated(EnumType.STRING)
    private WordType type;
}
