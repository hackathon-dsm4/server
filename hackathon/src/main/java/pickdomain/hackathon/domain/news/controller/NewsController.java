package pickdomain.hackathon.domain.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.news.dto.QueryAllNewsResponse;
import pickdomain.hackathon.domain.news.dto.QueryNewsResponse;
import pickdomain.hackathon.domain.news.service.NewsSerivce;
import pickdomain.hackathon.domain.news.service.QueryNewsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final QueryNewsService queryNewsService;
//    @GetMapping
//    public String news(
//            @RequestParam(value = "category") String type
//    ) {
//        return newsSerivce.news(type);
//    };

    @GetMapping("/{id}")
    public QueryNewsResponse queryNews(@PathVariable Long id) {
        return queryNewsService.execute(id);
    }

    @GetMapping("/all")
    public List<QueryAllNewsResponse> all() {
        return queryNewsService.all();
    }
}

