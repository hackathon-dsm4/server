package pickdomain.hackathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pickdomain.hackathon.domain.user.dto.response.InfoUserResponse;
import pickdomain.hackathon.domain.user.entity.User;
import pickdomain.hackathon.domain.user.facade.UserFacade;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public InfoUserResponse execute() {
        User user = userFacade.getCurrentUser();
        return new InfoUserResponse(user);
    }
}
