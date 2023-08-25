package ir.maktabsharif92.springboot.resource;

import ir.maktabsharif92.springboot.mapper.AboutUsMapper;
import ir.maktabsharif92.springboot.service.AboutUsService;
import ir.maktabsharif92.springboot.service.dto.AboutUsDTO;
import ir.maktabsharif92.springboot.util.SecurityInformationUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/about-us")
@RequiredArgsConstructor
public class AboutUsResource {

    private final AboutUsService baseService;

    private final AboutUsMapper mapper;

    @GetMapping
    @PreAuthorize("hasAuthority('" + SecurityInformationUtil.ABOUT_US_READ + "')")
    public ResponseEntity<AboutUsDTO> get() {
        return ResponseEntity.ok(
                mapper.convertToDTO(
                        baseService.get()
                )
        );
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + SecurityInformationUtil.ABOUT_US_UPDATE + "')")
    public ResponseEntity<AboutUsDTO> update(@RequestBody @Valid AboutUsDTO dto) {
        return ResponseEntity.ok(
                mapper.convertToDTO(
                        baseService.update(dto.getContent())
                )
        );
    }
}
