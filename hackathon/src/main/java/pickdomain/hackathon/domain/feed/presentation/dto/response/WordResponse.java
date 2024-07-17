package pickdomain.hackathon.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Type;

import java.time.LocalDateTime;

@Getter
@Builder
public class WordResponse {
    private Long wordId;
    private String word;
    private Integer count;
    private LocalDateTime issueDate;
    private Type kind;
}
