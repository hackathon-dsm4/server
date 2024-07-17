package pickdomain.hackathon.domain.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.feed.entity.Notice;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.news.dto.Notices;
import pickdomain.hackathon.domain.news.dto.QueryAllNewsResponse;
import pickdomain.hackathon.domain.news.dto.QueryNewsResponse;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsLikeRepository;
import pickdomain.hackathon.domain.news.repository.NewsRepository;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryNewsService {
    private final NewsRepository newsRepository;
    private final FeedRepository feedRepository;
    private final NewsLikeRepository newsLikeRepository;
    private final UserFacade userFacade;

    public QueryNewsResponse execute(Long id) {
        News news = newsRepository.findById(id).orElse(null);
        List<Notice> notices = feedRepository.findAllByNews(news);

        List<Notices> noticesList = news.getNotices().stream()
                .map(n -> new Notices(
                        n.getContent(),
                        n.getUser().getName(),
                        n.getUser().getProfileImage(),
                        n.getCount()
                ))
                .collect(Collectors.toList());

        return new QueryNewsResponse(
                news.getTitle(),
                news.getOriginallink(),
                news.getDescription(),
                news.getPubDate(),
                news.getLink(),
                news.getType(),
                news.getCount(),
                isAlreadyLiked(news, userFacade.getCurrentUser()),
                noticesList
        );
    }


    public List<QueryAllNewsResponse> all() {

        return newsRepository.findAll().stream()
                .map(it -> new QueryAllNewsResponse(
                        it.getId(),
                        it.getTitle(),
                        it.getType(),
                        it.getJob(),
                        it.getProfile(),
                        it.getCount(),
                        isAlreadyLiked(it, userFacade.getCurrentUser())
                ))
                .sorted(Comparator.comparingInt(QueryAllNewsResponse::getCount).reversed())
                .collect(Collectors.toList());
    }

        private boolean isAlreadyLiked(News news, User user) {
        if (user == null) {
            return false; // or throw an exception
        }
        return newsLikeRepository.existsByUserAndNews(user, news);
    }
}
