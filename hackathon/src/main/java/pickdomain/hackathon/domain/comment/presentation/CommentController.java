package pickdomain.hackathon.domain.comment.presentation;



import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.comment.presentation.dto.request.CreateCommentRequest;
import pickdomain.hackathon.domain.comment.presentation.dto.response.CreateCommentResponse;
import pickdomain.hackathon.domain.comment.service.CreateCommentService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;

    //댓글 작성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public CreateCommentResponse createComment(@PathVariable("id") Long id, @RequestBody @Valid CreateCommentRequest request) {
        return createCommentService.execute(id, request);
    }

}
