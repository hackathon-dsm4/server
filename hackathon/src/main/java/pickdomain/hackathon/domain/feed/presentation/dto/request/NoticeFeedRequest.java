package pickdomain.hackathon.domain.feed.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeFeedRequest {
    @NotNull(message = "내용는 Null이 될 수 없으며 최대 1500자까지 가능합니다.")
    @Size(max = 1500)
    private String content;
}
