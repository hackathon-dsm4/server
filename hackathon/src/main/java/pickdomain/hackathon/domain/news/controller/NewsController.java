package pickdomain.hackathon.domain.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.news.service.NewsSerivce;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsSerivce newsSerivce;
    @GetMapping
    public String news(
            @RequestParam(value = "category") Type type
    ) {
        return newsSerivce.news(type);
    };
}
