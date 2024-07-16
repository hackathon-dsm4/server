package pickdomain.hackathon.global.ouath;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {

        @Override
        public Exception decode(String methodKey, Response response) {
            if (response.status() == 401) {
                // Unauthorized (401) 에러 처리
                return new Exception();
            } else if (response.status() == 404) {
                // Not Found (404) 에러 처리
                return new Exception();
            }

            // 기본적으로는 FeignException을 던집니다.
            return FeignException.errorStatus(methodKey, response);
        }
    }
}
