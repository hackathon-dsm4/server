package pickdomain.hackathon.domain.user.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class UserAlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION = new UserAlreadyExistException();
    private UserAlreadyExistException() {
        super(ErrorCode.USER_EXIST);
    }

}
