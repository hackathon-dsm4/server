package pickdomain.hackathon.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;
import pickdomain.hackathon.domain.user.repository.UserRepository;
import pickdomain.hackathon.global.ouath.AuthLoginRequest;
import pickdomain.hackathon.global.ouath.GoogleClient;
import pickdomain.hackathon.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final GoogleClient googleClient;

    public TokenResponse signIn(AuthLoginRequest request) {
        User user = signInByGoogle(request.getToken());
        User findUser = userRepository.findByEmail(user.getEmail())
                .orElse(null);
        if (findUser == null) { // 최초 로그인이라면 회원가입 시키기
            userRepository.save(user);
        }

        return jwtTokenProvider.generateAccessToken(user);
    }

    private User signInByGoogle(String token) {
        return User.createUserByGoogleLogin(googleClient.getUserInfo(token));
    }

}
