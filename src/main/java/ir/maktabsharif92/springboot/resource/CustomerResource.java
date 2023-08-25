package ir.maktabsharif92.springboot.resource;

import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.mapper.CustomerMapper;
import ir.maktabsharif92.springboot.service.CustomerService;
import ir.maktabsharif92.springboot.service.dto.CustomerCardboardDTO;
import ir.maktabsharif92.springboot.service.dto.CustomerProfileDTO;
import ir.maktabsharif92.springboot.service.dto.CustomerSearch;
import ir.maktabsharif92.springboot.service.dto.projection.CustomerMyProfileProjection;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService baseService;

    private final CustomerMapper mapper;

    @PostMapping("/advance-search/page")
    @PreAuthorize("hasAuthority('" + SecurityInformationUtil.CUSTOMER_READ_ALL + "')")
    public ResponseEntity<Page<CustomerCardboardDTO>> doAdvanceSearch(@RequestBody CustomerSearch search,
                                                                      Pageable pageable) {
        Page<Customer> page = baseService.doAdvanceSearch(search, pageable);

        return ResponseEntity.ok(
                page.map(mapper::convertToCardboardDTO)
        );
    }

    @GetMapping("/my-profile")
    @PreAuthorize("hasAuthority('" + SecurityInformationUtil.CUSTOMER_ROLE + "')")
    public ResponseEntity<CustomerProfileDTO> getMyProfile() {
        CustomerMyProfileProjection myProfile = baseService.getMyProfile();
        return ResponseEntity.ok(
                mapper.convertToProfileDTO(myProfile)
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + SecurityInformationUtil.CUSTOMER_READ + "')")
    public ResponseEntity<CustomerProfileDTO> getCustomerProfile(@PathVariable("id") Long id) {
        CustomerMyProfileProjection myProfile = baseService.getCustomerProfile(id);
        return ResponseEntity.ok(
                mapper.convertToProfileDTO(myProfile)
        );
    }
}
