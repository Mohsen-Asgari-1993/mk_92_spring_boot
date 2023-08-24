package ir.maktabsharif92.springboot.init;

import ir.maktabsharif92.springboot.base.service.PermissionService;
import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.base.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInitializer {

    private final PermissionService permissionService;
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void init() {
        permissionService.init();
        roleService.init();
        userService.init();
    }
}
