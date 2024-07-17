package pickdomain.hackathon.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.user.entity.User;

@Getter
@AllArgsConstructor
public class UserNoticeResponse {
    private String title;
    private String content;
    private Type type;
    private Integer count;
    private String userName;
    private String userProfile;
    private Boolean click;

}
