package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.Permission;
import ir.maktabsharif92.springboot.base.repository.PermissionRepository;
import ir.maktabsharif92.springboot.base.service.PermissionService;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository baseRepository;

    @Override
    public void init() {
        if (count() == 0) {
            baseRepository.save(
                    new Permission(SecurityInformationUtil.ADMIN_PERMISSION)
            );
        }
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

    @Override
    public Permission findByName(String name) {
        return baseRepository.findByName(name);
    }
}
