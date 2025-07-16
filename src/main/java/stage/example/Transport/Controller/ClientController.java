package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Dto.DemandeDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Mapper.ContratMapper;
import stage.example.Transport.Mapper.DemandeMapper;
import stage.example.Transport.Services.ContratService;
import stage.example.Transport.Services.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class ClientController
{
    @Autowired
    private UserService userService;
    @Autowired
    private ContratService contratService;
    @Autowired
    private stage.example.Transport.Service.DemandeService demandeService;
    @Autowired
    private DemandeMapper demandeMapper;
    @Autowired
    private ContratMapper contratMapper;

    @GetMapping("/getClientContrats/{clientId}")
    public ResponseEntity<List<ContratDto>> getContratsByClient(@PathVariable Long clientId) {
        List<Contrat> contrats = contratService.getContratsByClientId(clientId);
        List<ContratDto> dtoList = contrats.stream()
                .map(contratMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/demandes/{clientId}")
    public ResponseEntity<List<DemandeDto>> getDemandesByClient(@PathVariable Long clientId) {
        List<Demande> demandes = demandeService.getDemandesByUserId(clientId);
        List<DemandeDto> dtoList = demandes.stream()
                .map(demandeMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
    @PostMapping("/createDemande/{clientId}")
    public ResponseEntity<DemandeDto> createDemande(@PathVariable Long clientId, @RequestBody DemandeDto demandeDto) {
        // Étape 1 : récupérer le contrat
        Optional<Contrat> contratOpt = contratRepository.findById(demandeDto.getContratId());

        if (contratOpt.isEmpty()) {
            return ResponseEntity.badRequest().build(); // ou un message personnalisé
        }

        Contrat contrat = contratOpt.get();

        // Vérifier que le contrat appartient bien au client (sécurité)
        if (!contrat.getClient().getId().equals(clientId)) {
            return ResponseEntity.status(403).build(); // interdiction d'accéder à un contrat d'un autre client
        }

        // Étape 2 : mapper le DTO en entité
        Demande demande = demandeMapper.toEntity(demandeDto);
        demande.setContrat(contrat); // Étape 3 : associer le contrat

        // Étape 4 : sauvegarder
        Demande saved = demandeService.saveDemande(demande);
        return ResponseEntity.ok(demandeMapper.toDto(saved));
    }



}
