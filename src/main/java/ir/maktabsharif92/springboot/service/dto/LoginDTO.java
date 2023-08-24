package ir.maktabsharif92.springboot.service.dto;

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
public class LoginDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 8, max = 16)
    private String password;
}
