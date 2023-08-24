package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.User;
import ir.maktabsharif92.springboot.base.repository.UserRepository;
import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.base.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseUserServiceImpl<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository baseRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        super(baseRepository, roleService, passwordEncoder);
    }

}
