package pickdomain.hackathon.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refreshToken")
public class RefreshToken {
    @Id
    private String id;
    @Indexed
    private String token;
    @TimeToLive
    private Long ttl;

    public RefreshToken(
          String id,String token
    ) {
        this.id = id;
        this.token = token;
    }

    public void update(String newToken, Long ttl) {
        this.id = newToken;
        this.ttl = ttl;
    }
}
