package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.presentation.dto.response.NoticeResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryNoticeService {
    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponse> execute() {
        return feedRepository.findAll()
                .stream()
                .map(NoticeResponse::noticeResponse)
                .collect(Collectors.toList());
    }
}
