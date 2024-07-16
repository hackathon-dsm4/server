package pickdomain.hackathon.global.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}