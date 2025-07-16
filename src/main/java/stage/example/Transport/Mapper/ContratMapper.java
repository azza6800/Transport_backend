package stage.example.Transport.Mapper;

import org.mapstruct.*;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Entite.Contrat;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ContratMapper {

    ContratDto toDto(Contrat contrat);
    Contrat toEntity(ContratDto dto);
}
