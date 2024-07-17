package pickdomain.hackathon.domain.news.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.news.entity.News;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@AllArgsConstructor
public class QueryNewsResponse {
    private String title;
    private String originallink;
    private String description;
    private String pubDate;
    private String link;
    private Type type;
    private Integer count;
    private Boolean click;
    private List<Notices> notices;
}

