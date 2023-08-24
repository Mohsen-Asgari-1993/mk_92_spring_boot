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
public class CustomerSearch implements Serializable {

    private String firstName;

    private String lastName;

    private String username;

    private Gender gender;
}
