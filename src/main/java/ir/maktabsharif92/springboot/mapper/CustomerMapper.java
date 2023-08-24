package ir.maktabsharif92.springboot.mapper;

import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.service.dto.CustomerCardboardDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerCardboardDTO convertToCardboardDTO(Customer customer);

}
