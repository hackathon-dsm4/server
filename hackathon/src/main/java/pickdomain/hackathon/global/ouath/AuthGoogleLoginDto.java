package pickdomain.hackathon.global.ouath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AuthGoogleLoginDto {
    private String name;
    private String email;
    private String picture;
}
