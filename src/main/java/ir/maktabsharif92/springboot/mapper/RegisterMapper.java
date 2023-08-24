package ir.maktabsharif92.springboot.mapper;

import ir.maktabsharif92.springboot.service.dto.Register;
import ir.maktabsharif92.springboot.service.dto.RegisterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {

    Register convertToRegister(RegisterDTO dto);

}
