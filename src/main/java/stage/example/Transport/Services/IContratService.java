package stage.example.Transport.Services;

import stage.example.Transport.Entite.Contrat;

import java.util.List;
import java.util.Optional;

public interface IContratService {


    Contrat saveContrat(Contrat contrat);

    Optional<Contrat> getContratById(Long id);

    List<Contrat> getAllContrats();

    List<Contrat> getContratsByClientId(Long clientId);



    Contrat closeContrat(Long id);

    void fermerContratsExpireAujourdHui();
}
