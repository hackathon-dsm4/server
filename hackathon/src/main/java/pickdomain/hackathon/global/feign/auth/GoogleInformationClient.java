package pickdomain.hackathon.global.feign.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pickdomain.hackathon.global.feign.auth.res.GoogleInformationResponse;

@FeignClient(name = "GoogleInformationClient", url = "https://www.googleapis.com/oauth2/v1/userinfo")
public interface GoogleInformationClient {
    @GetMapping("?alt=json&access_token={TOKEN}")
    GoogleInformationResponse getUserInformation(@PathVariable("TOKEN") String accessToken);
}
