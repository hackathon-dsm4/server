package pickdomain.hackathon.domain.feed.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.feed.service.LikeService;

@Tag(name = "Like", description = "Like API 입니다.")
@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @ApiOperation("좋아요 누르기 눌렀으면 취소")
    @PostMapping("/{id}")
    public Integer add(@PathVariable Long id) {
        return  likeService.execute(id);
    }
}
