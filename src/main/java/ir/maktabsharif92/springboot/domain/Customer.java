package ir.maktabsharif92.springboot.domain;

import ir.maktabsharif92.springboot.base.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    public static final String CODE = "code";

    @Column(name = CODE)
    private String code;
}
