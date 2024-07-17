package pickdomain.hackathon.domain.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.feed.service.LikeService;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{id}")
    public Integer add(@PathVariable Long id) {
        return  likeService.execute(id);
    }
}
