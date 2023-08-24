package ir.maktabsharif92.springboot.service.dto;

import ir.maktabsharif92.springboot.base.validation.MobileNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyDTO implements Serializable {

    @NotBlank
    @Size(min = 4, max = 4)
    private String code;

    @MobileNumber
    private String mobileNumber;
}
