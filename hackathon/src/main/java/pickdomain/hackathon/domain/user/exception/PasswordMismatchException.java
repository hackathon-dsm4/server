package pickdomain.hackathon.domain.user.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
