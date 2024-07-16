package pickdomain.hackathon.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.user.dto.request.SignupRequest;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.exception.UserAlreadyExistException;
import pickdomain.hackathon.domain.user.repository.UserRepository;
import pickdomain.hackathon.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SignupRequest request) {
        if(userRepository.existsById(request.getId())) throw UserAlreadyExistException.EXCEPTION;

        User user = userRepository.save(User.builder()
                        .id(request.getId())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }

}
