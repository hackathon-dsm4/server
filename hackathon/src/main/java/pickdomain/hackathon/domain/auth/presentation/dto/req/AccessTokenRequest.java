package pickdomain.hackathon.domain.auth.presentation.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessTokenRequest {
    private String token;
}
