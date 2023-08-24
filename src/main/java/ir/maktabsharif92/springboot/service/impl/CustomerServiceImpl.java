package ir.maktabsharif92.springboot.service.impl;

import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.base.service.impl.BaseUserServiceImpl;
import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.repository.CustomerRepository;
import ir.maktabsharif92.springboot.service.CustomerService;
import ir.maktabsharif92.springboot.service.dto.Register;
import ir.maktabsharif92.springboot.service.dto.VerifyDTO;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl extends BaseUserServiceImpl<Customer, CustomerRepository>
        implements CustomerService {

    private final static String REGISTER_SESSION_NAME = "REGISTER_SESSION_NAME";

    public CustomerServiceImpl(CustomerRepository baseRepository, RoleService roleService,
                               PasswordEncoder passwordEncoder) {
        super(baseRepository, roleService, passwordEncoder);
    }

    @Override
    public void sendCodeForNewCustomer(Register register, HttpSession httpSession) {
        checkMobileNumber(register.getMobileNumber());

        String randomNumeric = RandomStringUtils.randomNumeric(4);
        System.out.println(randomNumeric);
        register.setCode(randomNumeric);
//        TODO send sms or email

        httpSession.setAttribute(
                REGISTER_SESSION_NAME,
                register
        );

    }

    @Override
    @Transactional
    public void verifyCodeForNewCustomer(VerifyDTO dto, HttpSession httpSession) {
        Register register = (Register) httpSession.getAttribute(REGISTER_SESSION_NAME);
        if (register == null) {
            throw new RuntimeException("empty session");
        }
        if (!dto.getMobileNumber().equals(register.getMobileNumber())) {
            throw new RuntimeException("wrong mobileNumber");
        }
        checkMobileNumber(register.getMobileNumber());

        Customer customer = new Customer();
        customer.setFirstName(register.getFirstName());
        customer.setLastName(register.getLastName());
        customer.setUsername(register.getMobileNumber());
        customer.setPassword(
                passwordEncoder.encode(register.getPassword())
        );
        customer.setCreateDate(ZonedDateTime.now());
        customer.setRoles(
                Set.of(
                        roleService.createIfNotExistsAndGet(
                                SecurityInformationUtil.CUSTOMER_ROLE
                        )
                )
        );

        baseRepository.save(customer);

    }

    private void checkMobileNumber(String mobileNumber) {
        if (baseRepository.existsByUsername(mobileNumber)) {
            throw new RuntimeException("duplicate mobileNumber");
        }
    }
}
