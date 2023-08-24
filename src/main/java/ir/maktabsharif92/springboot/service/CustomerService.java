package ir.maktabsharif92.springboot.service;

import ir.maktabsharif92.springboot.service.dto.Register;
import jakarta.servlet.http.HttpSession;

public interface CustomerService {

    void sendCodeForNewCustomer(Register register, HttpSession httpSession);


}
