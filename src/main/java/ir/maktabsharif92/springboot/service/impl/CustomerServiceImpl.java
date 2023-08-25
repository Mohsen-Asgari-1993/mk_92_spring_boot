package ir.maktabsharif92.springboot.service.impl;

import ir.maktabsharif92.springboot.base.domain.enumeration.Gender;
import ir.maktabsharif92.springboot.base.service.RoleService;
import ir.maktabsharif92.springboot.base.service.impl.BaseUserServiceImpl;
import ir.maktabsharif92.springboot.base.util.SecurityUtil;
import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.domain.enumeration.UserType;
import ir.maktabsharif92.springboot.repository.CustomerRepository;
import ir.maktabsharif92.springboot.service.CustomerService;
import ir.maktabsharif92.springboot.service.dto.CustomerSearch;
import ir.maktabsharif92.springboot.service.dto.Register;
import ir.maktabsharif92.springboot.service.dto.VerifyDTO;
import ir.maktabsharif92.springboot.service.dto.projection.CustomerMyProfileProjection;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
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
        customer.setUserType(UserType.CUSTOMER.name());
        customer.setRoles(
                Set.of(
                        roleService.createIfNotExistsAndGet(
                                SecurityInformationUtil.CUSTOMER_ROLE
                        )
                )
        );

        baseRepository.save(customer);

    }

    @Override
    public Page<Customer> doAdvanceSearch(CustomerSearch search, Pageable pageable) {
        return baseRepository.findAll(
                (root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    fillFirstNamePredicate(predicates, root, criteriaBuilder, search.getFirstName());
                    fillLastNamePredicate(predicates, root, criteriaBuilder, search.getLastName());
                    fillUsernamePredicate(predicates, root, criteriaBuilder, search.getUsername());
                    fillGenderPredicate(predicates, root, criteriaBuilder, search.getGender());
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                },
                pageable
        );
    }

    @Override
    public CustomerMyProfileProjection getMyProfile() {
        return baseRepository.findById(
                SecurityUtil.getCurrentUserId(),
                CustomerMyProfileProjection.class
        );
    }

    @Override
    public CustomerMyProfileProjection getCustomerProfile(Long id) {
        return baseRepository.findById(
                id,
                CustomerMyProfileProjection.class
        );
    }

    private void fillFirstNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                        CriteriaBuilder criteriaBuilder, String firstName) {
        if (StringUtils.isNotBlank(firstName)) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("firstName"), "%" + firstName.trim() + "%"
                    )
            );
        }
    }

    private void fillLastNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                       CriteriaBuilder criteriaBuilder, String lastName) {
        if (StringUtils.isNotBlank(lastName)) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"), "%" + lastName.trim() + "%"
                    )
            );
        }
    }

    private void fillUsernamePredicate(List<Predicate> predicates, Root<Customer> root,
                                       CriteriaBuilder criteriaBuilder, String username) {
        if (StringUtils.isNotBlank(username)) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("username"), "%" + username.trim() + "%"
                    )
            );
        }
    }

    private void fillGenderPredicate(List<Predicate> predicates, Root<Customer> root,
                                     CriteriaBuilder criteriaBuilder, Gender gender) {
        if (gender != null) {
            predicates.add(
                    criteriaBuilder.equal(
                            root.get("gender"), gender
                    )
            );
        }
    }

    private void checkMobileNumber(String mobileNumber) {
        if (baseRepository.existsByUsername(mobileNumber)) {
            throw new RuntimeException("duplicate mobileNumber");
        }
    }
}
