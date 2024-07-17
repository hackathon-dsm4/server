package pickdomain.hackathon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.entity.Type;

@Getter
@Builder
public class UserNoticeResponse {
    private String title;
    private String content;
    private Type type;
    private Integer like;
    private String profile;

    public static UserNoticeResponse userMyPageResponse(Feed feed) {
        return UserNoticeResponse.builder()
                .title(feed.getNews().getTitle())
                .content(feed.getContent())
                .type(feed.getNews().getType())
                .like(feed.getLike())
                .profile(feed.getUser().getProfileImage())
                .build();
    }
}
