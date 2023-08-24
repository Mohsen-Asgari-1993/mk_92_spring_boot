package ir.maktabsharif92.springboot.resource;

import ir.maktabsharif92.springboot.mapper.RegisterMapper;
import ir.maktabsharif92.springboot.service.CustomerService;
import ir.maktabsharif92.springboot.service.dto.RegisterDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ns/register")
@RequiredArgsConstructor
public class RegisterResource {

    private final CustomerService customerService;

    private final RegisterMapper mapper;

    @PostMapping("/customer")
    public ResponseEntity<?> sendCodeForNewCustomer(@RequestBody @Valid RegisterDTO dto, HttpSession httpSession) {
        customerService.sendCodeForNewCustomer(
                mapper.convertToRegister(dto),
                httpSession
        );
        return ResponseEntity.ok().build();
    }
}
