package stage.example.Transport.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.example.Transport.Dto.DemandeDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Mapper.ContratMapper;
import stage.example.Transport.Mapper.DemandeMapper;
import stage.example.Transport.Repository.ContratRepository;
import stage.example.Transport.Repository.DemandeRepository;
import stage.example.Transport.Services.IDemandeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeService implements IDemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private DemandeMapper demandeMapper;

    @Override
    public Demande saveDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    @Override
    public Optional<Demande> getDemandeById(Long id) {
        return demandeRepository.findById(id);
    }
    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override
    public List<Demande> getDemandesByUserId(Long userId) {
        return demandeRepository.findByContratClientId(userId);
    }

    @Override
    public List<Demande> getDemandesByContratId(Long contratId) {
        return demandeRepository.findByContratId(contratId);
    }
    @Override
    public List<Demande> getDemandesByStatut(String statut) {
        return demandeRepository.findByStatut(statut);
    }
    @Override
    public List<Demande> getDemandesByAgence(Long numAgence) {
        List<Contrat> contrats = contratRepository.findByClientNumAgence(numAgence);
        List<Demande> result = new ArrayList<>();
        for (Contrat contrat : contrats) {
            result.addAll(demandeRepository.findByContratId(contrat.getId()));
        }
        return result;
    }
    @Override
    public Demande createDemandeFromDto(Long clientId, DemandeDto dto) {
        Optional<Contrat> contratOpt = contratRepository.findById(dto.getContratId());
        if (contratOpt.isEmpty()) {
            throw new RuntimeException("Contrat introuvable");
        }

        Contrat contrat = contratOpt.get();
        if (!contrat.getClient().getId().equals(clientId)) {
            throw new RuntimeException("Ce contrat n'appartient pas au client");
        }

        Demande demande = demandeMapper.toEntity(dto);
        demande.setContrat(contrat);

        return demandeRepository.save(demande);
    }

}
