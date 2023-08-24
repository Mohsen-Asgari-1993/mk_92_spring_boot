package ir.maktabsharif92.springboot.base.config.security;

import ir.maktabsharif92.springboot.base.domain.User;
import ir.maktabsharif92.springboot.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByUsername(username.trim());
        if (userOptional.isPresent()) {
            return new CustomUserDetails(
                    userOptional.get()
            );
        }
        throw new UsernameNotFoundException(username + " not found");
    }
}
