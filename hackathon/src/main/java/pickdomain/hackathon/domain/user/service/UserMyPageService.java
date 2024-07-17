package pickdomain.hackathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.entity.Feed;
import pickdomain.hackathon.domain.feed.entity.FeedLike;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.repository.LikeRepository;
import pickdomain.hackathon.domain.user.dto.response.UserNoticeResponse;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class UserMyPageService {
    private final FeedRepository feedRepository;
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;

    public List<UserNoticeResponse> queryMyNotice() {
        User user = userFacade.getCurrentUser();
        return feedRepository.findByUser(user).stream()
                .map(UserNoticeResponse::userMyPageResponse)
                .collect(Collectors.toList());
    }

    public List<UserNoticeResponse> queryShareNotice() {
        User currentUser = userFacade.getCurrentUser();
        List<FeedLike> likes = likeRepository.findByUser(currentUser);

        List<UserNoticeResponse> userNoticeResponses = likes.stream()
                .map(like -> {
                    Feed feed = like.getFeed();
                    return UserNoticeResponse.userMyPageResponse(feed);
                })
                .collect(Collectors.toList());
        return userNoticeResponses;
    }
}
