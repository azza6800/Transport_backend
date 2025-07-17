package stage.example.Transport.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.StatutContrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {





    List<Contrat> findByClientId_Id(Long clientId);





    List<Contrat> findByStatut(StatutContrat ouvert);
}
