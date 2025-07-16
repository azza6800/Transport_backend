package stage.example.Transport.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Repository.ContratRepository;

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
        return contratRepository.findByClientId(clientId);
    }
    public List<Contrat> getContratsByAgenceId(Long agenceId) {
        return contratRepository.findByClientNumAgence(agenceId);
    }
}
