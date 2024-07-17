package pickdomain.hackathon.domain.feed.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.feed.presentation.dto.response.WordResponse;
import pickdomain.hackathon.domain.feed.service.WordCloudService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloud")
@RequiredArgsConstructor
public class WordCloudController {
    private final WordCloudService wordCloudService;

    @PostMapping("/add")
    public Map<String, Integer> asdf(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam("date")
            LocalDate dateTime,
            @RequestParam("type")String type
    ) { return  wordCloudService.generateWordCloud(dateTime,type);}

    @ApiOperation("워드클라우드 조회")
    @GetMapping
    public List<WordResponse> fsf(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam("date")
            LocalDate dateTime,
            @RequestParam("type")String type
    ) {
        return wordCloudService.getWord(dateTime, type);
    }

}
