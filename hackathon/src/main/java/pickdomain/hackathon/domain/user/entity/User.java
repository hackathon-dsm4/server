package pickdomain.hackathon.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pickdomain.hackathon.global.ouath.AuthGoogleLoginDto;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String profileImage;

    @Builder
    public User(String name, String email, String profileImage) {
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
    }

    public static User createUserByGoogleLogin(AuthGoogleLoginDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .profileImage(dto.getPicture())
                .build();
    }
}
