package ir.maktabsharif92.springboot.service.dto;

import ir.maktabsharif92.springboot.base.domain.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyProfileUpdateDTO implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Gender gender;

}
