package pickdomain.hackathon.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.user.exception.UserNotFoundException;
import pickdomain.hackathon.domain.user.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return new AuthDetails(
                userRepository.findById(userId)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        );
    }
}