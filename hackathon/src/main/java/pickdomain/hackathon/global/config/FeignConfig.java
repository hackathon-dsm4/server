package pickdomain.hackathon.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "pickdomain.hackathon.global.feign")
public class FeignConfig {
}
