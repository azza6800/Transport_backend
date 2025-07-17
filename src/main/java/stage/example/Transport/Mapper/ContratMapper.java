package stage.example.Transport.Mapper;

import org.mapstruct.*;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.User;

@Mapper(componentModel = "spring", uses = {UserMapper.class })
public interface ContratMapper {

    @Mapping(source = "clientId", target = "client.id") // pour aller de DTO vers Entité
    Contrat toEntity(ContratDto dto);

    @Mapping(source = "client.id", target = "clientId") // pour aller d'Entité vers DTO
    ContratDto toDto(Contrat entity);
}
