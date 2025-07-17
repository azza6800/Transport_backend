package stage.example.Transport.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.example.Transport.Entite.Agence;
import stage.example.Transport.Entite.Contrat;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
