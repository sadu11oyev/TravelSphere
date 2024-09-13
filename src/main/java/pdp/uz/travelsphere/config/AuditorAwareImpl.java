package pdp.uz.travelsphere.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pdp.uz.travelsphere.entity.User;
import pdp.uz.travelsphere.repo.UserRepository;

@Component
@RequiredArgsConstructor
public class AuditorAwareImpl {
    private final UserRepository userRepository;

    public User getAuthenticatedUser(String phone){
        String phoneNumber = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(phone);
    }
}
