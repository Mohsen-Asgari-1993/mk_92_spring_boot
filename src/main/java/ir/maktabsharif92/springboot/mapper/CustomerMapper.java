package ir.maktabsharif92.springboot.mapper;

import ir.maktabsharif92.springboot.domain.Customer;
import ir.maktabsharif92.springboot.service.dto.CustomerCardboardDTO;
import ir.maktabsharif92.springboot.service.dto.CustomerProfileDTO;
import ir.maktabsharif92.springboot.service.dto.projection.CustomerMyProfileProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerCardboardDTO convertToCardboardDTO(Customer customer);

    CustomerProfileDTO convertToProfileDTO(CustomerMyProfileProjection projection);

}
