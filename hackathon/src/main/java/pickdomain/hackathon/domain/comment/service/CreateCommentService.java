package pickdomain.hackathon.domain.comment.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.comment.domain.Comment;
import pickdomain.hackathon.domain.comment.domain.repository.CommentRepository;
import pickdomain.hackathon.domain.comment.presentation.dto.request.CreateCommentRequest;
import pickdomain.hackathon.domain.comment.presentation.dto.response.CreateCommentResponse;
import pickdomain.hackathon.domain.feed.exception.FeedNotFoundException;
import pickdomain.hackathon.domain.feed.repository.FeedRepository;
import pickdomain.hackathon.domain.news.entity.News;
import pickdomain.hackathon.domain.news.repository.NewsRepository;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final UserFacade userFacade;
    private final NewsRepository newsRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CreateCommentResponse execute(Long id, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();

        News news = newsRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        Comment comment = Comment.builder()
                .news(news)
                .user(user)
                .content(request.getContent())
                .build();

        commentRepository.save(comment);

        return new CreateCommentResponse(comment.getId(), comment.getContent());
    }
}
