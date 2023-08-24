package ir.maktabsharif92.springboot.base.util;

import ir.maktabsharif92.springboot.base.config.security.CustomUserDetails;
import ir.maktabsharif92.springboot.base.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SuppressWarnings("unused")
public class SecurityUtil {

    private SecurityUtil() {
    }

    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    public static User getCurrentUser() {
        return isAuthenticated() ?
                ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser() : null;
    }

    public static Long getCurrentUserId() {
        return isAuthenticated() ?
                ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId()
                : null;
    }

    public static String getCurrentUsername() {
        return isAuthenticated() ?
                ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUsername()
                : null;
    }

    public static String getCurrentUserType() {
        return isAuthenticated() ?
                ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUserType()
                : null;
    }

}
