package pickdomain.hackathon.domain.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.feed.service.WordCloudService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/cloud")
@RequiredArgsConstructor
public class WordCloudController {
    private final WordCloudService wordCloudService;

    @GetMapping
    public Map<String, Integer> asdf(
            @RequestParam("date")LocalDateTime dateTime,
            @RequestParam("type")Type type
    ) { return  wordCloudService.generateWordCloud(dateTime,type);}
}
