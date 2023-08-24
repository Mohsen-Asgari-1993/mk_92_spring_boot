package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.Permission;
import ir.maktabsharif92.springboot.base.domain.Role;
import ir.maktabsharif92.springboot.base.repository.RoleRepository;
import ir.maktabsharif92.springboot.base.service.PermissionService;
import ir.maktabsharif92.springboot.base.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository baseRepository;

    private final PermissionService permissionService;

    @Override
    public Role findByName(String name) {
        return baseRepository.findByName(name);
    }

    @Override
    @Transactional
    public Role createIfNotExistsAndGet(String name) {
        Role role = baseRepository.findByName(name);
        if (role == null) {
            role = new Role(name, new HashSet<>());
            return baseRepository.save(role);
        }
        return role;
    }

    @Override
    @Transactional
    public void saveOrUpdate(String roleName, Set<Permission> permissionSet) {
        Role role = findByName(roleName);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
        }
        role.setPermissions(permissionSet);
        baseRepository.save(role);
    }
}
