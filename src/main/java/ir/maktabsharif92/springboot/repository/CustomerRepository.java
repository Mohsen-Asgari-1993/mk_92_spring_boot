package ir.maktabsharif92.springboot.repository;

import ir.maktabsharif92.springboot.base.repository.BaseUserRepository;
import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.service.dto.CustomerMyProfileDTO;
import ir.maktabsharif92.springboot.service.dto.projection.CustomerMyProfileProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends BaseUserRepository<Customer> {


    @Query("select new ir.maktabsharif92.springboot.service.dto." +
            "CustomerMyProfileDTO(c.id, c.firstName, c.lastName, c.nationalCode, c.gender) " +
            "from Customer c where c.id = :id")
    CustomerMyProfileDTO findByIdForMyProfile(@Param("id") Long id);

    CustomerMyProfileProjection findByIdAndIdIsNotNull(Long id);

    <P> P findById(Long id, Class<P> projectionClass);
}
