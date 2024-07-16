package pickdomain.hackathon.domain.feed.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.feed.presentation.dto.request.NoticeFeedRequest;
import pickdomain.hackathon.domain.feed.presentation.dto.response.NoticeResponse;
import pickdomain.hackathon.domain.feed.service.NoticeFeedService;
import pickdomain.hackathon.domain.feed.service.QueryNoticeService;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeFeedService noticeFeedService;
    private final QueryNoticeService queryNoticeService;

    @PostMapping
    public void createNotice(@RequestBody NoticeFeedRequest noticeFeedRequest) {
        noticeFeedService.execute(noticeFeedRequest);
    }

    @GetMapping
    public List<NoticeResponse> queryNotice() {
        return queryNoticeService.execute();
    }
}
