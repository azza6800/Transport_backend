package stage.example.Transport.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.example.Transport.Entite.Demande;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

    List<Demande> findByContratClientId(Long userId);

    List<Demande> findByStatut(String statut);

    List<Demande> findByContratId(Long contratId);
}
