package stage.example.Transport.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.example.Transport.Entite.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findByClientId(Long clientId);

    List<Contrat> findByClientNumAgence(Long numAgence);



}
