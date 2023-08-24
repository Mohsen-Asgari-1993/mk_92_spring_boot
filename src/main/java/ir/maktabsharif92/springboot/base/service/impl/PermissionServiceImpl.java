package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.repository.PermissionRepository;
import ir.maktabsharif92.springboot.base.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository baseRepository;
}
