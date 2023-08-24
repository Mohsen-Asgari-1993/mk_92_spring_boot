package ir.maktabsharif92.springboot.base.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Role.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<Long> {

    public static final String TABLE_NAME = "role_tbl";
    public static final String NAME = "name";
    public static final String ROLE_PERMISSION_JOIN_TABLE = "role_permission_join_table";

    @Column(name = NAME, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = ROLE_PERMISSION_JOIN_TABLE)
    private Set<Permission> permissions = new HashSet<>();
}
