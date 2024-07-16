package pickdomain.hackathon.domain.user.facade;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.exception.PasswordMismatchException;
import pickdomain.hackathon.domain.user.exception.UserNotFoundException;
import pickdomain.hackathon.domain.user.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User findByUserId(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getCurrentUser () {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByUserId(id);
    }
}