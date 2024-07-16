package pickdomain.hackathon.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.service.UserLoginService;
import pickdomain.hackathon.global.ouath.AuthLoginRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserLoginService userLoginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody AuthLoginRequest authLoginRequest){
        return userLoginService.signIn(authLoginRequest);
    }

}
