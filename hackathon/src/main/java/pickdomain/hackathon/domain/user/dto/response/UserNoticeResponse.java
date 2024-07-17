package pickdomain.hackathon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.user.entity.User;

@Getter
@Builder
public class UserNoticeResponse {
    private String title;
    private String content;
    private Type type;
    private Integer like;
    private String user;
    private String profile;

    public static UserNoticeResponse userMyPageResponse(Notice feed) {
        return UserNoticeResponse.builder()
                .title(feed.getNews().getTitle())
                .content(feed.getContent())
                .type(feed.getNews().getType())
                .like(feed.getCount())
                .user(feed.getUser().getName())
                .profile(feed.getUser().getProfileImage())
                .build();
    }
}
