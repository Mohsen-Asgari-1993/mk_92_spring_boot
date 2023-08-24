package ir.maktabsharif92.springboot.base.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Permission.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseEntity<Long> {

    public static final String TABLE_NAME = "permission_tbl";
    public static final String NAME = "name";

    @Column(name = NAME, unique = true)
    private String name;
}
