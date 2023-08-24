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
public class RegisterDTO implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @MobileNumber
    private String mobileNumber;

    @NotBlank
    @Size(min = 8, max = 16)
    private String password;
}
