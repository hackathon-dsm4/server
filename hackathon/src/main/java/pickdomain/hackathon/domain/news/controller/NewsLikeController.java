package pickdomain.hackathon.domain.news.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.feed.presentation.dto.response.NoticeCountResponse;
import pickdomain.hackathon.domain.feed.service.LikeService;
import pickdomain.hackathon.domain.news.service.NewsLikeService;

@Tag(name = "Like", description = "Like API 입니다.")
@RestController
@RequestMapping("/newsLike")
@RequiredArgsConstructor
public class NewsLikeController {
    private final NewsLikeService newsLikeService;

    @ApiOperation("좋아요 누르기 눌렀으면 취소")
    @PostMapping("/{id}")
    public NoticeCountResponse add(@PathVariable Long id) {
        return  newsLikeService.execute(id);
    }
}
