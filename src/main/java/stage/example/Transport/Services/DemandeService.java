package stage.example.Transport.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.example.Transport.Dto.DemandeDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Entite.StatutContrat;
import stage.example.Transport.Entite.StatutDemande;
import stage.example.Transport.Mapper.DemandeMapper;
import stage.example.Transport.Repository.ContratRepository;
import stage.example.Transport.Repository.DemandeRepository;

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
        return demandeRepository.findByContratClient_Id(userId);
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
    @Override
    public Demande validerDemande(Long demandeId) {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée avec l'ID : " + demandeId));

        demande.setStatut(StatutDemande.VALIDEE);

        Contrat contrat = demande.getContrat();
        if ("VOYAGE".equals(contrat.getTypeContrat())) {
            contrat.setStatut(StatutContrat.FERME);
            contratRepository.save(contrat);
        }

        return demandeRepository.save(demande);
    }



}
