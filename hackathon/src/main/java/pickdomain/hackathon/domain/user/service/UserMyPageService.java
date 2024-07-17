package pickdomain.hackathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.entity.FeedLike;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.repository.LikeRepository;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.user.dto.response.UserNewsResponse;
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
                .map(it  ->new UserNoticeResponse(
                        it.getNews().getTitle(), it.getContent(), it.getNews().getType(), it.getCount(), it.getUser().getName(), it.getUser().getProfileImage(), isAlreadyLiked(it, user)
                ))
                .collect(Collectors.toList());
    }

    public List<UserNewsResponse> queryShareNotice() {
        User currentUser = userFacade.getCurrentUser();
        List<FeedLike> likes = likeRepository.findByUser(currentUser);

        List<UserNewsResponse> userNoticeResponses = likes.stream()
                .map(like -> {
                    News feed = like.getFeed().getNews();
                    return UserNewsResponse.userNewsResponse(feed);
                })
                .collect(Collectors.toList());
        return userNoticeResponses;
    }

    private boolean isAlreadyLiked(Notice news, User user) {
        if (user == null) {
            return false; // or throw an exception
        }
        return likeRepository.existsByUserAndFeed(user, news);
    }
}
