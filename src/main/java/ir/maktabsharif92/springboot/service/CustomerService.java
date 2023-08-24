package ir.maktabsharif92.springboot.service;

import ir.maktabsharif92.springboot.base.service.BaseUserService;
import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.service.dto.Register;
import ir.maktabsharif92.springboot.service.dto.VerifyDTO;
import jakarta.servlet.http.HttpSession;

public interface CustomerService extends BaseUserService<Customer> {

    void sendCodeForNewCustomer(Register register, HttpSession httpSession);

    void verifyCodeForNewCustomer(VerifyDTO dto, HttpSession httpSession);
}
