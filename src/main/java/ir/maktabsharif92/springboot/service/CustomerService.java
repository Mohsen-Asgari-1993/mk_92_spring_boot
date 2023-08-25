package ir.maktabsharif92.springboot.service;

import ir.maktabsharif92.springboot.base.service.BaseUserService;
import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.service.dto.CustomerSearch;
import ir.maktabsharif92.springboot.service.dto.Register;
import ir.maktabsharif92.springboot.service.dto.VerifyDTO;
import ir.maktabsharif92.springboot.service.dto.projection.CustomerMyProfileProjection;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends BaseUserService<Customer> {

    void sendCodeForNewCustomer(Register register, HttpSession httpSession);

    void verifyCodeForNewCustomer(VerifyDTO dto, HttpSession httpSession);

    Page<Customer> doAdvanceSearch(CustomerSearch search, Pageable pageable);

    CustomerMyProfileProjection getMyProfile();

    CustomerMyProfileProjection getCustomerProfile(Long id);
}
