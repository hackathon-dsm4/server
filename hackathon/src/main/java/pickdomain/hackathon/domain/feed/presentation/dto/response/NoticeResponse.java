package pickdomain.hackathon.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.user.entity.User;

@Getter
@AllArgsConstructor
public class NoticeResponse {
    private Long id;
    private String content;
    private String userName;
    private String title;
    private Type type;
    private Integer count;
    private String userProfile;
    private Long newsId;
    private Boolean click;
}
