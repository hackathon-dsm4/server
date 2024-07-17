package pickdomain.hackathon.domain.comment.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class InvalidCommentException extends CustomException {

    public static final Exception EXCEPTION =
            new InvalidCommentException();

    private InvalidCommentException() {
        super(ErrorCode.INVALID_COMMENT);
    }

}
