package ir.maktabsharif92.springboot.init;

import ir.maktabsharif92.springboot.base.domain.Permission;
import ir.maktabsharif92.springboot.base.service.PermissionService;
import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserInitializer {

    private final PermissionService permissionService;

    private final RoleService roleService;

    @PostConstruct
    public void init() {
        initRoleAndPermissions();
    }

    private void initRoleAndPermissions() {
        Map<String, Set<String>> rolePermissionMap = SecurityInformationUtil.rolePermissionMap;
        rolePermissionMap.forEach((roleName, permissions) -> {
            Set<Permission> permissionSet = new HashSet<>();
            if (CollectionUtils.isNotEmpty(permissions)) {
                permissionSet.addAll(
                        permissionService.saveAll(permissions)
                );
            }
            roleService.saveOrUpdate(roleName, permissionSet);
        });
    }
}
