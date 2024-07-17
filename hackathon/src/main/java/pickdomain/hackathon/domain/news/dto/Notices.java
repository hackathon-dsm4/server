package pickdomain.hackathon.domain.news.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notices{
    private String content;
    private String userName;
    private String userProfile;
    private Integer count;
}