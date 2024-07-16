package pickdomain.hackathon.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.auth.presentation.dto.req.AccessTokenRequest;
import pickdomain.hackathon.domain.auth.presentation.dto.req.CreateAccessTokenRequest;
import pickdomain.hackathon.domain.auth.presentation.dto.res.AccessTokenResponse;
import pickdomain.hackathon.domain.auth.presentation.dto.res.TokenResponse;
import pickdomain.hackathon.domain.auth.service.CreateAccessTokenService;
import pickdomain.hackathon.domain.auth.service.GoogleAuthLinkService;
import pickdomain.hackathon.domain.auth.service.GoogleAuthService;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final GoogleAuthLinkService googleAuthLinkService;
    private final GoogleAuthService googleAuthService;
    private final CreateAccessTokenService createNewAccessToken;

    @GetMapping
    public String getGoogleAuthLink() {
        return googleAuthLinkService.execute();
    }

    @PostMapping
    public TokenResponse login(@RequestBody AccessTokenRequest accessTokenRequest) {
        return googleAuthService.execute(accessTokenRequest.getAccessToken());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/refresh")
    public AccessTokenResponse createNewAccessToken(@RequestBody CreateAccessTokenRequest request) {
        return createNewAccessToken.execute(request.getRefreshToken());
    }
}
