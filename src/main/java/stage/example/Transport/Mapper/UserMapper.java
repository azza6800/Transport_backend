package stage.example.Transport.Mapper;

import org.mapstruct.Mapper;
import stage.example.Transport.Dto.UserDto;
import stage.example.Transport.Entite.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}


