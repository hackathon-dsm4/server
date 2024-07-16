package pickdomain.hackathon.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.entity.User;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String ACCESS_KEY = "access";

    private final JwtProperties jwtProperties;

    public TokenResponse generateAccessToken(User user) {
        return new TokenResponse(generateToken(user.getEmail(), ACCESS_KEY, jwtProperties.getAccessExp()));
    }

    private String generateToken(String email, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .setSubject(email)
                .setHeaderParam("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }
}
