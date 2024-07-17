package pickdomain.hackathon.domain.comment.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
