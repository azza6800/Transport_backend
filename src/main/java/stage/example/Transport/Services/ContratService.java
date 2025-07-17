package stage.example.Transport.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.StatutContrat;
import stage.example.Transport.Repository.ContratRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ContratService implements  IContratService{


    @Autowired
    private ContratRepository contratRepository;
    @Override
    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
    @Override
    public Optional<Contrat> getContratById(Long id) {
        return contratRepository.findById(id);
    }
    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }
    @Override
    public List<Contrat> getContratsByClientId(Long clientId) {
        return contratRepository.findByClientId_Id(clientId);
    }

    @Override
    public Contrat closeContrat(Long id) {
        return contratRepository.findById(id).map(contrat -> {
            contrat.setStatut(StatutContrat.FERME);
            return contratRepository.save(contrat);
        }).orElseThrow(() -> new RuntimeException("Contrat non trouvé avec l'ID : " + id));
    }
    @Override
    public void fermerContratsExpireAujourdHui() {
        LocalDate today = LocalDate.now();
        List<Contrat> contrats = contratRepository.findByStatut(StatutContrat.OUVERT);
        for (Contrat contrat : contrats) {
            if (contrat.getDateFin() != null) {
                // Conversion de Date en LocalDate
                LocalDate dateFinLocal = contrat.getDateFin().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                if (dateFinLocal.isEqual(today)) {
                    contrat.setStatut(StatutContrat.FERME);
                    contratRepository.save(contrat);
                    System.out.println("Contrat ID " + contrat.getId() + " fermé automatiquement.");
                }
            }
        }
    }



}
