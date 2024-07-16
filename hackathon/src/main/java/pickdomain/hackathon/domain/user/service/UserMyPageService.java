package pickdomain.hackathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.repository.LikeRepository;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class UserMyPageService {
    private final FeedRepository feedRepository;
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;

    public void execute() {}
}
