package pickdomain.hackathon.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.feed.presentation.dto.response.NoticeResponse;
import pickdomain.hackathon.domain.feed.repository.LikeRepository;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryNoticeService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponse> execute() {

        return feedRepository.findAll()
                .stream()
                .map(it ->new NoticeResponse(
                        it.getFeedId(), it.getContent(), it.getUser().getName(), it.getNews().getTitle(), it.getNews().getType(), it.getCount(), it.getUser().getProfileImage(), it.getNews().getId(), isAlreadyLiked(it, userFacade.getCurrentUser())
                ))
                .collect(Collectors.toList());
    }

    private boolean isAlreadyLiked(Notice news, User user) {
        if (user == null) {
            return false; // or throw an exception
        }
        return likeRepository.existsByUserAndFeed(user, news);
    }
}
