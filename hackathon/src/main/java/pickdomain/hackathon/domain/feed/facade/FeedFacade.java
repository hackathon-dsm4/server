package pickdomain.hackathon.domain.feed.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.exception.FeedNotFoundException;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedById(Long id) {
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
