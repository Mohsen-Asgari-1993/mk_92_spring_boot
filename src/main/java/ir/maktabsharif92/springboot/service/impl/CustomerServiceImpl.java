package ir.maktabsharif92.springboot.service.impl;

import ir.maktabsharif92.springboot.repository.CustomerRepository;
import ir.maktabsharif92.springboot.service.CustomerService;
import ir.maktabsharif92.springboot.service.dto.Register;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository baseRepository;

    private final static String REGISTER_SESSION_NAME = "REGISTER_SESSION_NAME";

    @Override
    public void sendCodeForNewCustomer(Register register, HttpSession httpSession) {
        if (baseRepository.existsByUsername(register.getMobileNumber())) {
            throw new RuntimeException("duplicate mobileNumber");
        }

        String randomNumeric = RandomStringUtils.randomNumeric(4);
        System.out.println(randomNumeric);
        register.setCode(randomNumeric);
//        TODO send sms or email

        httpSession.setAttribute(
                REGISTER_SESSION_NAME,
                register
        );

    }
}
