package pickdomain.hackathon.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;

@Getter
@Builder
public class NoticeResponse {
    private String content;
//    private String userName;
    private String newsTitle;
    private Type type;
    private Integer like;
    private String user;

    public static NoticeResponse noticeResponse(Notice feed) {
        return NoticeResponse.builder()
                .content(feed.getContent())
                .newsTitle(feed.getNews().getTitle())
                .type(feed.getNews().getType())
                .like(feed.getCount())
                .user(feed.getUser().getName())
                .build();
    }
}
