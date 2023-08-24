package ir.maktabsharif92.springboot.base.repository;

import ir.maktabsharif92.springboot.base.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseUserRepository<E extends User> extends BaseEntityRepository<E, Long> {

    //    @EntityGraph(attributePaths = {"roles", "roles.permissions"})
    @EntityGraph(value = User.FETCH_ROLE_PERMISSIONS)
    Optional<E> findByUsername(String username);
}
