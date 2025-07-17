package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Dto.DemandeDto;
import stage.example.Transport.Dto.UserDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Entite.StatutDemande;
import stage.example.Transport.Mapper.ContratMapper;
import stage.example.Transport.Mapper.DemandeMapper;
import stage.example.Transport.Mapper.UserMapper;
import stage.example.Transport.Services.ContratService;
import stage.example.Transport.Services.DemandeService;
import stage.example.Transport.Services.UserService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/Agent")

public class AgentController
{
    @Autowired
    private UserService userService;
    @Autowired
    private ContratService contratService;
    @Autowired
    private DemandeService demandeService;
    @Autowired
    private DemandeMapper demandeMapper;
    @Autowired
    private ContratMapper contratMapper;
    @Autowired
    private UserMapper userMapper;

    @PutMapping("/validerDemande/{id}")
    public ResponseEntity<DemandeDto> validerDemande(@PathVariable Long id) {
        Demande demande = demandeService.validerDemande(id);
        return ResponseEntity.ok(demandeMapper.toDto(demande));
    }

    @GetMapping("/getClientsByAgence/{numAgence}")
    public List<UserDto> getClientsByAgence(@PathVariable Long numAgence) {
        return userService.getUsersByAgenceAndRole(numAgence, "CLIENT")
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/createDemande")
    public DemandeDto createDemande(@RequestBody DemandeDto demandeDto) {
        Demande demande = demandeMapper.toEntity(demandeDto);
        Demande saved = demandeService.saveDemande(demande);
        return demandeMapper.toDto(saved);
    }

    @PutMapping("/demandes/refuser/{id}")
    public ResponseEntity<String> refuserDemande(@PathVariable Long id) {
        Demande demande = demandeService.getDemandeById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
        demande.setStatut(StatutDemande.REFUSEE);
        demandeService.saveDemande(demande);
        return ResponseEntity.ok("Demande refusée");
    }




}
