package pickdomain.hackathon.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeCountResponse {
    private Integer count;
    private Boolean click;
}
