package pickdomain.hackathon.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "User", description = "User API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserLoginService userLoginService;
    private final UserMyPageService userMyPageService;

    @Operation(summary = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody AuthLoginRequest authLoginRequest){
        return userLoginService.signIn(authLoginRequest);
    }

    @Operation(summary = "내가 생성한 게시글 확인")
    @GetMapping("my-notice")
    public List<UserNoticeResponse> myNotice() {
        return userMyPageService.queryMyNotice();
    }

    @Operation(summary = "내가 좋아요 누른 게시글 확인")
    @GetMapping("my-share")
    public List<UserNoticeResponse> myShare() {
        return userMyPageService.queryShareNotice();
    }
}
