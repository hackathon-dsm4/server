package pickdomain.hackathon.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import pickdomain.hackathon.domain.feed.entity.Cloud;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.news.entity.News;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class NoticeWordResponse {
    private String word;
    private List<Query> queryList;

    public static NoticeWordResponse noticeWordResponse(News news, String cloud) {
        List<Query> queryList = new ArrayList<>();
        queryList.add(new Query(
                news.getType(),
                news.getId(),
                news.getDescription(),
                news.getJob()
        ));

        return NoticeWordResponse.builder()
                .word(cloud)
                .queryList(queryList)
                .build();
    }
}

@Getter
@Builder
class Query {
    private Type type;
    private Long id;
    private String content;
    private String job;

    public Query(Type type, Long id, String content, String job) {
        this.type = type;
        this.id = id;
        this.content = content;
        this.job = job;
    }
}
