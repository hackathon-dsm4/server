package pickdomain.hackathon.domain.user.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import pickdomain.hackathon.domain.user.dto.response.UserNoticeResponse;
import pickdomain.hackathon.domain.user.service.UserMyPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.user.dto.response.InfoUserResponse;
import pickdomain.hackathon.domain.user.service.ProfileService;

import java.util.List;

@Tag(name = "User", description = "User API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final ProfileService profileService;
    private final UserMyPageService userMyPageService;

    @Operation(summary = "내정보확인")
    @GetMapping
    public InfoUserResponse findMyInfo() {
        return profileService.execute();
    }

    @ApiOperation( "내가 생성한 게시글 확인")
    @GetMapping("my-notice")
    public List<UserNoticeResponse> myNotice() {
        return userMyPageService.queryMyNotice();
    }

    @ApiOperation("내가 좋아요 누른 게시글 확인")
    @GetMapping("my-share")
    public List<UserNoticeResponse> myShare() {
        return userMyPageService.queryShareNotice();
    }
}
