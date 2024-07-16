package pickdomain.hackathon.domain.feed.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.feed.presentation.dto.request.NoticeFeedRequest;
import pickdomain.hackathon.domain.feed.presentation.dto.response.NoticeResponse;
import pickdomain.hackathon.domain.feed.service.NoticeFeedService;
import pickdomain.hackathon.domain.feed.service.QueryNoticeService;

import java.util.List;

@Tag(name = "Feed", description = "Feed API 입니다.")
@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeFeedService noticeFeedService;
    private final QueryNoticeService queryNoticeService;

    @Operation(summary = "게시글등록")
    @PostMapping
    public void createNotice(@RequestBody NoticeFeedRequest noticeFeedRequest) {
        noticeFeedService.execute(noticeFeedRequest);
    }

    @Operation(summary = "게시글 전체조회")
    @GetMapping
    public List<NoticeResponse> queryNotice() {
        return queryNoticeService.execute();
    }
}
