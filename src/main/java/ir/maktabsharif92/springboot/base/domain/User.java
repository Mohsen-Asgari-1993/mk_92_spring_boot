package ir.maktabsharif92.springboot.base.domain;

import ir.maktabsharif92.springboot.base.domain.enumeration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraphs(
        value = {
                @NamedEntityGraph(
                        name = User.FETCH_ROLE_PERMISSIONS,
                        attributeNodes = {
                                @NamedAttributeNode(value = "roles", subgraph = "roles_permission")
                        },
                        subgraphs = {
                                @NamedSubgraph(
                                        name = "roles_permission",
                                        attributeNodes = {
                                                @NamedAttributeNode(value = "permissions")
                                        }
                                )
                        }
                )
        }
)
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "base_user";
    public static final String FETCH_ROLE_PERMISSIONS = "fetch_role_permissions";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NATIONAL_CODE = "national_code";
    public static final String GENDER = "gender";
    public static final String USERS_ROLE = "users_role";
    public static final String IS_ENABLED = "is_enabled";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USERNAME)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = NATIONAL_CODE)
    private String nationalCode;

    @Column(name = GENDER)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    @JoinTable(name = USERS_ROLE)
    private Set<Role> roles = new HashSet<>();

    @Column(name = IS_ENABLED)
    private Boolean isEnabled = true;
}
