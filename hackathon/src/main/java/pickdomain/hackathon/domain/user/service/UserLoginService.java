package pickdomain.hackathon.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.user.dto.request.SigninRequest;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;
import pickdomain.hackathon.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SigninRequest request){
        User user = userFacade.findByUserId(request.getId());
        userFacade.checkPassword(user, request.getPassword());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }

}
