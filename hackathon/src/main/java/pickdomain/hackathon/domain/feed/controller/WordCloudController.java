package pickdomain.hackathon.domain.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.feed.presentation.dto.response.WordResponse;
import pickdomain.hackathon.domain.feed.service.WordCloudService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloud")
@RequiredArgsConstructor
public class WordCloudController {
    private final WordCloudService wordCloudService;

    @PostMapping
    public Map<String, Integer> asdf(
            @RequestParam("date")LocalDateTime dateTime,
            @RequestParam("type")Type type
    ) { return  wordCloudService.generateWordCloud(dateTime,type);}

    @GetMapping
    public List<WordResponse> fsf(
            @RequestParam("date")LocalDateTime dateTime,
            @RequestParam("type")Type type
    ) {
        return wordCloudService.getWord(dateTime, type);
    }

}
