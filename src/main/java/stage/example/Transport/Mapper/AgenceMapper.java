package stage.example.Transport.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import stage.example.Transport.Dto.AgenceDto;
import stage.example.Transport.Entite.Agence;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapperHelper.class})
public interface AgenceMapper {

    @Mapping(target = "clientIds", source = "clients")
    AgenceDto toDto(Agence agence);

    @Mapping(target = "clients", source = "clientIds")
    Agence toEntity(AgenceDto dto);

    List<AgenceDto> toDtoList(List<Agence> agences);
    List<Agence> toEntityList(List<AgenceDto> dtos);
}
