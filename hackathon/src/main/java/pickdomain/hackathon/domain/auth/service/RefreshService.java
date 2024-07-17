package pickdomain.hackathon.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.auth.presentation.dto.res.TokenResponse;
import pickdomain.hackathon.global.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class RefreshService {
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse refresh(String token) {
        return jwtTokenProvider.reIssue(token);
    }
}
