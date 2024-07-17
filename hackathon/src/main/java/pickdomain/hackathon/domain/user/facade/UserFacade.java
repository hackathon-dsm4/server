package pickdomain.hackathon.domain.user.facade;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.exception.UserNotFoundException;
import pickdomain.hackathon.domain.user.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User findByEmail(String userId) {
        return userRepository.findByEmail(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getCurrentUser () {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByEmail(id);
    }
}