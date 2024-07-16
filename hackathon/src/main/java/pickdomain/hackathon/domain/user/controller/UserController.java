package pickdomain.hackathon.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.user.dto.response.InfoUserResponse;
import pickdomain.hackathon.domain.user.service.ProfileService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final ProfileService profileService;

    @GetMapping
    public InfoUserResponse findMyInfo() {
        return profileService.execute();
    }
}
