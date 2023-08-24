package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.repository.RoleRepository;
import ir.maktabsharif92.springboot.base.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository baseRepository;
}
