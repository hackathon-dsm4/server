package pickdomain.hackathon.domain.news.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QueryNewsResponse {
    private Long id;
    private String title;
    private String content;
    private String createAt;
    private String editor;
    private List<String> image;
}
