package pickdomain.hackathon.domain.user.exception;

import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
