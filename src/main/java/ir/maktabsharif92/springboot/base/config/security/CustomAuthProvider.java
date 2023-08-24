package ir.maktabsharif92.springboot.base.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(
                authentication.getName()
        );
        if (passwordEncoder.matches(((String) authentication.getCredentials()), userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
        }
        throw new BadCredentialsException("wrong information");
    }

    @Override
    public boolean supports(Class<?> authentication) {
//        TODO add token
        return true;
    }
}
