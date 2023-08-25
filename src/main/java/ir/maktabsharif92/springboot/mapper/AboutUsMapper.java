package ir.maktabsharif92.springboot.mapper;

import ir.maktabsharif92.springboot.domain.AboutUs;
import ir.maktabsharif92.springboot.service.dto.AboutUsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AboutUsMapper {

    AboutUsDTO convertToDTO(AboutUs aboutUs);

}
