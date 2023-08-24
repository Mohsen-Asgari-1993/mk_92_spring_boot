package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.Role;
import ir.maktabsharif92.springboot.base.repository.RoleRepository;
import ir.maktabsharif92.springboot.base.service.PermissionService;
import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository baseRepository;

    private final PermissionService permissionService;

    @Override
    public void init() {
        if (baseRepository.count() == 0 && permissionService.count() > 0) {
            baseRepository.save(
                    new Role(
                            SecurityInformationUtil.ADMIN_ROLE,
                            Set.of(
                                    permissionService.findByName(
                                            SecurityInformationUtil.ADMIN_PERMISSION
                                    )
                            )
                    )
            );
        }
    }

    @Override
    public Role findByName(String name) {
        return baseRepository.findByName(name);
    }
}
