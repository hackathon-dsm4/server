package pickdomain.hackathon.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.auth.domain.RefreshToken;
import pickdomain.hackathon.domain.auth.domain.repository.RefreshTokenRepository;
import pickdomain.hackathon.domain.auth.presentation.dto.res.AccessTokenResponse;
import pickdomain.hackathon.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Service
public class CreateAccessTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return new AccessTokenResponse(jwtTokenProvider
                .createAccessToken(refreshToken.getEmail()));
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token)
                .orElseThrow(() -> new IllegalArgumentException("EXPIRED_PERIOD_TOKEN"));
    }
}
