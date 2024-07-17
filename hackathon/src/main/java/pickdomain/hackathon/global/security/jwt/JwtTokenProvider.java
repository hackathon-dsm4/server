package pickdomain.hackathon.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.auth.domain.RefreshToken;
import pickdomain.hackathon.domain.auth.domain.repository.RefreshTokenRepository;
import pickdomain.hackathon.domain.auth.presentation.dto.res.TokenResponse;
import pickdomain.hackathon.global.config.properties.JwtProperties;
import pickdomain.hackathon.global.exception.InvalidJwtException;
import pickdomain.hackathon.global.security.principle.AuthDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    private static final String ACCESS_KEY = "access_token";
    private static final String REFRESH_KEY = "refresh_token";

    @Transactional
    public TokenResponse createToken(String email) {
        String token = refreshToken(REFRESH_KEY, jwtProperties.getRefreshTime());
        String accessToken = createToken(email, ACCESS_KEY, 1000*jwtProperties.getAccessTime());
        refreshTokenRepository.save(
                new RefreshToken(email,token)
        );
        return new TokenResponse(accessToken, token);
    }

    private String createToken(String email, String type, Long time) {
        Date now = new Date();
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(email)
                .setHeaderParam("typ", type)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + time))
                .compact();
    }

    private String refreshToken(String type, Long time) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("typ", type)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshTime() * 1000))
                .setIssuedAt(new Date())
                .compact();
    }

    public TokenResponse reIssue(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshToken);
        if (token != null) {
            String id = token.getId();

            TokenResponse tokenResponse = createToken(id);
            token.update(tokenResponse.getRefreshToken(), jwtProperties.getRefreshTime());
            refreshTokenRepository.save(token);
            return new TokenResponse(tokenResponse.getAccessToken(), tokenResponse.getRefreshToken());
        } else {
            throw InvalidJwtException.EXCEPTION;
        }
    }



    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "");
        }
        return null;
    }

    public UsernamePasswordAuthenticationToken authorization(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getTokenSubject(String subject) {
        return getTokenBody(subject).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw pickdomain.hackathon.global.exception.ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }
}
