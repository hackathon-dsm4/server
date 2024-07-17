package pickdomain.hackathon.global.security.principle;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return new AuthDetails(userFacade.findByEmail(email));
    }
}
