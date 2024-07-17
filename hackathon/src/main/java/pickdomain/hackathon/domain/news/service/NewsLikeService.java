package pickdomain.hackathon.domain.news.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.entity.NewsLike;
import pickdomain.hackathon.domain.news.repository.NewsLikeRepository;
import pickdomain.hackathon.domain.news.repository.NewsRepository;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class NewsLikeService {
    private final NewsLikeRepository newsLikeRepository;
    private final NewsRepository newsRepository;
    private final UserFacade userFacade;

    @Transactional
    public Integer execute(Long newsId) {
        News news = newsRepository.findById(newsId).orElseThrow(()-> new RuntimeException());
        User user = userFacade.getCurrentUser();

        if (newsLikeRepository.existsByUserAndNews(user, news)){
            newsLikeRepository.deleteByUserAndNews(user, news);
            news.minusLike();
            return news.getCount();
        }
        newsLikeRepository.save(
                NewsLike.builder()
                        .user(user)
                        .news(news)
                        .build()
        );
        news.addLike();
        return news.getCount();
    }
}
