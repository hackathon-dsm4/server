package pickdomain.hackathon.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.user.dto.request.SigninRequest;
import pickdomain.hackathon.domain.user.dto.request.SignupRequest;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.service.UserLoginService;
import pickdomain.hackathon.domain.user.service.UserSignupService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserLoginService userLoginService;
    private final UserSignupService userSignupService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) { return userSignupService.execute(request); }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signin")
    public TokenResponse login(@RequestBody @Valid SigninRequest request){
        return userLoginService.execute(request);
    }

}
