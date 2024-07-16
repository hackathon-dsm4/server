package pickdomain.hackathon.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    CANNOT_BE_DELETED(401, "Cannot Be Deleted"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),
    CANNOT_BE_MODIFIED(401, "Cannot Be Modified"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),

    USER_EXIST(409, "user Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}