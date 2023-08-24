package ir.maktabsharif92.springboot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Register implements Serializable {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String password;

    private String code;
}
