package ir.maktabsharif92.springboot.domain;

import ir.maktabsharif92.springboot.base.domain.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Admin extends User {

}
