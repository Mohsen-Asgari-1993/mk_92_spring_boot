package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.Permission;
import ir.maktabsharif92.springboot.base.repository.PermissionRepository;
import ir.maktabsharif92.springboot.base.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository baseRepository;

    @Override
    public Permission findByName(String name) {
        return baseRepository.findByName(name);
    }

    @Override
    @Transactional
    public Set<Permission> saveAll(Set<String> permissions) {
        Set<Permission> permissionSet = new HashSet<>();
        permissions.forEach(permissionName -> {
            Permission byName = baseRepository.findByName(permissionName);
            if (byName == null) {
                byName = baseRepository.save(
                        new Permission(permissionName)
                );
            }
            permissionSet.add(byName);
        });
        return permissionSet;
    }
}
