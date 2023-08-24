package ir.maktabsharif92.springboot.base.repository;

import ir.maktabsharif92.springboot.base.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseEntityRepository<E extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
}
