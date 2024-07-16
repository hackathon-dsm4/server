package pickdomain.hackathon.domain.feed.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class CannotBeDeletedException extends CustomException {

    public static final CannotBeDeletedException EXCEPTION =
            new CannotBeDeletedException();

    private CannotBeDeletedException() {
        super(ErrorCode.CANNOT_BE_DELETED);
    }
}
