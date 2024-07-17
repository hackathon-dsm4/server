package pickdomain.hackathon.domain.news.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Type;

@Getter
@AllArgsConstructor
public class QueryAllNewsResponse {
    private String title;
    private Type type;
    private String job;
    private String profile;
    private Integer count;
}
