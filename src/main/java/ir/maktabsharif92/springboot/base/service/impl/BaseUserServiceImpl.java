package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.User;
import ir.maktabsharif92.springboot.base.repository.BaseUserRepository;
import ir.maktabsharif92.springboot.base.service.BaseUserService;
import ir.maktabsharif92.springboot.base.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class BaseUserServiceImpl<E extends User, R extends BaseUserRepository<E>>
        implements BaseUserService<E> {

    protected final R baseRepository;

    protected final RoleService roleService;

    protected final PasswordEncoder passwordEncoder;

    @Override
    public Optional<E> findByUsername(String username) {
        return baseRepository.findByUsername(username);
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

}
