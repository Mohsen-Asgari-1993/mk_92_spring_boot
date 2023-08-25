package ir.maktabsharif92.springboot.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.mapper.CustomerMapper;
import ir.maktabsharif92.springboot.service.CustomerService;
import ir.maktabsharif92.springboot.service.dto.CustomerCardboardDTO;
import ir.maktabsharif92.springboot.service.dto.CustomerMyProfileUpdateDTO;
import ir.maktabsharif92.springboot.service.dto.CustomerProfileDTO;
import ir.maktabsharif92.springboot.service.dto.CustomerSearch;
import ir.maktabsharif92.springboot.service.dto.projection.CustomerMyProfileProjection;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import jakarta.validation.Valid;
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
    @Operation(summary = "search on customers, can be used by admin", description = "description search on customer")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(
                            responseCode = "400",
                            content = {
                                    @Content(
                                            examples = {
                                                    @ExampleObject(value = "{ \"data\" : \"example of data\"  }", name = "test", summary = "summary of test")
                                            }
                                    )
                            }
                    )
            }
    )
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

    @PutMapping("/my-profile")
    @PreAuthorize("hasAuthority('" + SecurityInformationUtil.CUSTOMER_ROLE + "')")
    public ResponseEntity<CustomerProfileDTO> updateMyProfile(@RequestBody @Valid CustomerMyProfileUpdateDTO dto) {
        Customer customer = baseService.updateMyProfile(dto);
        return ResponseEntity.ok(
                mapper.convertToProfileDTO(customer)
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
