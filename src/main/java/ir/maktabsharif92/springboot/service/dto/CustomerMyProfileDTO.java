package ir.maktabsharif92.springboot.service.dto;

import ir.maktabsharif92.springboot.base.domain.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyProfileDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String nationalCode;

    private Gender gender;

}
