package pickdomain.hackathon.domain.feed.presentation.dto.response;

import com.mysql.cj.protocol.x.Notice;
import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.user.entity.User;

@Getter
@Builder
public class NoticeResponse {
    private String content;
//    private String userName;
    private String newsTitle;
    private Type type;
    private Integer like;
    private String user;

    public static NoticeResponse noticeResponse(Feed feed) {
        return NoticeResponse.builder()
                .content(feed.getContent())
                .newsTitle(feed.getNews().getTitle())
                .type(feed.getNews().getType())
                .like(feed.getLike())
                .user(feed.getUser().getName())
                .build();
    }
}
