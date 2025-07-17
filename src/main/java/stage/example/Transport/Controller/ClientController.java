package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Dto.DemandeDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.Demande;
import stage.example.Transport.Mapper.ContratMapper;
import stage.example.Transport.Mapper.DemandeMapper;
import stage.example.Transport.Services.ContratService;
import stage.example.Transport.Services.DemandeService;
import stage.example.Transport.Services.UserService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/client")

public class ClientController
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

    @GetMapping("/getClientContrats/{clientId}")
    public ResponseEntity<List<ContratDto>> getContratsByClient(@PathVariable Long clientId) {
        List<Contrat> contrats = contratService.getContratsByClientId(clientId);
        List<ContratDto> dtoList = contrats.stream()
                .map(contratMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/getDemandesByClient/{clientId}")
    public ResponseEntity<List<DemandeDto>> getDemandesByClient(@PathVariable Long clientId) {
        List<Demande> demandes = demandeService.getDemandesByUserId(clientId);
        List<DemandeDto> dtoList = demandes.stream()
                .map(demandeMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
    @PostMapping("/createDemande/{clientId}")
    public ResponseEntity<DemandeDto> createDemande(@PathVariable Long clientId, @RequestBody DemandeDto demandeDto) {
        try {
            Demande demande = demandeService.createDemandeFromDto(clientId, demandeDto);
            return ResponseEntity.ok(demandeMapper.toDto(demande));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}
