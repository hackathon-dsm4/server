package pickdomain.hackathon.domain.feed.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class CannotBeModifiedException extends CustomException {

    public static final CannotBeModifiedException EXCEPTION =
            new CannotBeModifiedException();

    private CannotBeModifiedException() {
        super(ErrorCode.CANNOT_BE_MODIFIED);
    }
}
