package ir.maktabsharif92.springboot.base.service.impl;

import ir.maktabsharif92.springboot.base.domain.User;
import ir.maktabsharif92.springboot.base.repository.UserRepository;
import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.base.service.UserService;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl extends BaseUserServiceImpl<User, UserRepository> implements UserService {


    public UserServiceImpl(UserRepository baseRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        super(baseRepository, roleService, passwordEncoder);
    }

    @Override
    @Transactional
    public void init() {
        if (count() == 0) {
            User user = new User();
            user.setFirstName("محسن");
            user.setLastName("عسگری");
            user.setUsername("mohsen");
            user.setPassword(
                    passwordEncoder.encode(
                            "123456789"
                    )
            );
            user.setIsEnabled(true);
            user.setRoles(
                    Set.of(
                            roleService.findByName(
                                    SecurityInformationUtil.ADMIN_ROLE
                            )
                    )
            );
            baseRepository.save(user);
        }
    }
}
