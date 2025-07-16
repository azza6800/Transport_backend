package stage.example.Transport.Mapper;

import org.mapstruct.*;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Dto.DemandeDto;

    @Mapper(componentModel = "spring",uses = {ContratMapper.class})
public interface DemandeMapper {

    DemandeDto toDto(Demande demande);

    Demande toEntity(DemandeDto dto);
}
