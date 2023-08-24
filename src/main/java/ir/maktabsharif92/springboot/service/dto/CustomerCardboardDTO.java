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
public class CustomerCardboardDTO implements Serializable {

    private Long id;

    private String firstName;
}
