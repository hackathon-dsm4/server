package pickdomain.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pickdomain.hackathon.domain.news.service.NewsSerivce;

@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

}
