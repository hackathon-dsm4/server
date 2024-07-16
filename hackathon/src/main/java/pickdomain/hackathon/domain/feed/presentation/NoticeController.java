package pickdomain.hackathon.domain.feed.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.feed.presentation.dto.request.NoticeFeedRequest;
import pickdomain.hackathon.domain.feed.service.NoticeFeedService;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeFeedService noticeFeedService;

    @PostMapping
    public void createNotice(@RequestBody NoticeFeedRequest noticeFeedRequest) {
        noticeFeedService.execute(noticeFeedRequest);
    }
}
