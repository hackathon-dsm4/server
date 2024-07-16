package pickdomain.hackathon.domain.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pickdomain.hackathon.domain.user.entity.User;

@Getter
@RequiredArgsConstructor
public class InfoUserResponse {
    private String email;
    private String nickname;
    private String profile;

    public InfoUserResponse(User user) {
        this.email = user.getEmail();
        this.nickname = user.getName();
        this.profile = user.getProfileImage();
    }
}
