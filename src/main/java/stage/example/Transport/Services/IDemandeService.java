package stage.example.Transport.Services;

import stage.example.Transport.Dto.DemandeDto;
import stage.example.Transport.Entite.Demande;

import java.util.List;
import java.util.Optional;

public interface IDemandeService {

    Demande saveDemande(Demande demande);

    Optional<Demande> getDemandeById(Long id);


    List<Demande> getAllDemandes();

    List<Demande> getDemandesByUserId(Long userId);


    List<Demande> getDemandesByContratId(Long contratId);

    List<Demande> getDemandesByStatut(String statut);

    Demande createDemandeFromDto(Long clientId, DemandeDto dto);


    Demande validerDemande(Long demandeId);
}
