package pickdomain.hackathon.domain.user.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pickdomain.hackathon.domain.user.dto.response.TokenResponse;
import pickdomain.hackathon.domain.user.dto.response.UserNoticeResponse;
import pickdomain.hackathon.domain.user.service.UserLoginService;
import pickdomain.hackathon.domain.user.service.UserMyPageService;
import pickdomain.hackathon.global.ouath.AuthLoginRequest;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserLoginService userLoginService;
    private final UserMyPageService userMyPageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody AuthLoginRequest authLoginRequest){
        return userLoginService.signIn(authLoginRequest);
    }

    @GetMapping("my-notice")
    public List<UserNoticeResponse> myNotice() {
        return userMyPageService.queryMyNotice();
    }

    @GetMapping("my-share")
    public List<UserNoticeResponse> myShare() {
        return userMyPageService.queryShareNotice();
    }
}
