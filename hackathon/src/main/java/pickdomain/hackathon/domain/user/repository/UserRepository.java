package pickdomain.hackathon.domain.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
