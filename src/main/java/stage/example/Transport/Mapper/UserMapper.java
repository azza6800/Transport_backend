package stage.example.Transport.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import stage.example.Transport.Dto.UserDto;
import stage.example.Transport.Entite.Agence;
import stage.example.Transport.Entite.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AgenceMapperHelper.class})
public interface UserMapper {

    @Mapping(target = "agenceIds", source = "agences")
    UserDto toDto(User user);

    @Mapping(target = "agences", source = "agenceIds")
    User toEntity(UserDto dto);

    List<UserDto> toDtoList(List<User> users);
    List<User> toEntityList(List<UserDto> dtos);
}

