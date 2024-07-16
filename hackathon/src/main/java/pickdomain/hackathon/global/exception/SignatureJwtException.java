package pickdomain.hackathon.global.exception;


import pickdomain.hackathon.global.error.CustomException;
import pickdomain.hackathon.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}