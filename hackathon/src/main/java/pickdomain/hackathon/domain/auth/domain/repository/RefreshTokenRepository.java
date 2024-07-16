package pickdomain.hackathon.domain.auth.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pickdomain.hackathon.domain.auth.domain.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
