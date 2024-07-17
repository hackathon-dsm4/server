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
    private final NewsLikeRepository newsLikeRepository; // 뉴스 좋아요 관련 Repository
    private final NewsRepository newsRepository; // 뉴스 관련 Repository
    private final UserFacade userFacade; // 현재 로그인한 사용자 정보 제공 Facade

    @Transactional // 메서드 실행을 하나의 트랜잭션으로 처리
    public Integer execute(Long id) {
        // 주어진 ID로 뉴스를 조회하고, 존재하지 않으면 RuntimeException 발생
        News news = newsRepository.findById(id).orElseThrow(() -> new RuntimeException("News not found"));

        // 현재 로그인한 사용자 정보를 가져옴
        User user = userFacade.getCurrentUser();

        // 사용자가 이미 해당 뉴스에 좋아요를 눌렀는지 확인
        if (isAlreadyLiked(news, user)) {
            // 이미 좋아요를 눌렀다면, 좋아요를 취소하고 뉴스의 좋아요 수를 감소시킴
            newsLikeRepository.deleteByUserAndNews(user, news);
            news.minusLike();
            // 현재 뉴스의 좋아요 수를 반환
            return news.getCount();
        }

        // 사용자가 아직 좋아요를 누르지 않았다면, 새로운 좋아요 엔티티를 저장하고 뉴스의 좋아요 수를 증가시킴
        newsLikeRepository.save(
                NewsLike.builder()
                        .user(user) // 좋아요를 누른 사용자
                        .news(news) // 좋아요를 받은 뉴스
                        .build()
        );
        news.addLike();
        return news.getCount();
    }

    private boolean isAlreadyLiked(News news, User user) {
        return newsLikeRepository.existsByUserAndNews(user, news);
    }
}
