package pickdomain.hackathon.domain.comment.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class CommentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
