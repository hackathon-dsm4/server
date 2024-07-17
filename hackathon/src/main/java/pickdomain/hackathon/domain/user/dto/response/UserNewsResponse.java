package pickdomain.hackathon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.news.entity.News;

@Getter
@Builder
public class UserNewsResponse {
    private String title;
    private String content;
    private Type type;
    private Integer count;
    private Long id;
    private String profile;

    public static UserNewsResponse userNewsResponse(News feed) {
        return UserNewsResponse.builder()
                .title(feed.getTitle())
                .content(feed.getDescription())
                .type(feed.getType())
                .count(feed.getCount())
                .id(feed.getId())
                .profile(feed.getProfile())
                .build();
    }
}
