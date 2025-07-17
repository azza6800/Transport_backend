package stage.example.Transport.Mapper;

import org.mapstruct.*;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Dto.DemandeDto;

    @Mapper(componentModel = "spring",uses = {ContratMapper.class})
public interface DemandeMapper {

        @Mapping(source = "agentValidateur.id", target = "agentValidateurId")
        DemandeDto toDto(Demande demande);

        @Mapping(source = "agentValidateurId", target = "agentValidateur.id")
        Demande toEntity(DemandeDto dto);

    }
