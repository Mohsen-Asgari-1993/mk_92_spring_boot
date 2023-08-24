package ir.maktabsharif92.springboot.service.impl;

import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.base.service.impl.BaseUserServiceImpl;
import ir.maktabsharif92.springboot.domain.Admin;
import ir.maktabsharif92.springboot.domain.enumeration.UserType;
import ir.maktabsharif92.springboot.repository.AdminRepository;
import ir.maktabsharif92.springboot.service.AdminService;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseUserServiceImpl<Admin, AdminRepository>
        implements AdminService {

    public AdminServiceImpl(AdminRepository baseRepository, RoleService roleService,
                            PasswordEncoder passwordEncoder) {
        super(baseRepository, roleService, passwordEncoder);
    }

    @Override
    @Transactional
    public void init() {
        if (count() == 0) {
            Admin admin = new Admin();
            admin.setFirstName("محسن");
            admin.setLastName("عسگری");
            admin.setUsername("mohsen");
            admin.setPassword(
                    passwordEncoder.encode(
                            "123456789"
                    )
            );
            admin.setUserType(UserType.ADMIN.name());
            admin.setCreateDate(ZonedDateTime.now());
            admin.setIsEnabled(true);
            admin.setRoles(
                    Set.of(
                            roleService.findByName(
                                    SecurityInformationUtil.ADMIN_ROLE
                            )
                    )
            );
            baseRepository.save(admin);
        }
    }
}
