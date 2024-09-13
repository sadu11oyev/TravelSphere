package pdp.uz.travelsphere.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import pdp.uz.travelsphere.dto.LoginDto;
import pdp.uz.travelsphere.dto.RegisterDto;
import pdp.uz.travelsphere.entity.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User registerDtoToEntity(RegisterDto registerDto);
    User loginDtoToEntity(LoginDto loginDto);

}
