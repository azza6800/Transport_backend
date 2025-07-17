package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Entite.StatutContrat;
import stage.example.Transport.Entite.TypeContrat;
import stage.example.Transport.Entite.User;
import stage.example.Transport.Mapper.ContratMapper;
import stage.example.Transport.Repository.UserRepository;
import stage.example.Transport.Services.IContratService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contrats")
public class ContratController {

    @Autowired
    private IContratService contratService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContratMapper contratMapper;

    @PostMapping("/createContrat")
    public ResponseEntity<Contrat> createContrat(@RequestBody ContratDto dto) {
        User client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        Contrat contrat = new Contrat();
        contrat.setTypeContrat(dto.getTypeContrat());
        contrat.setStatut(dto.getStatut());
        contrat.setDateEffet(dto.getDateEffet());
        contrat.setDateDelivrance(dto.getDateDelivrance());
        contrat.setDateFin(dto.getDateFin());
        contrat.setClient(client);

        Contrat saved = contratService.saveContrat(contrat);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getContratById/{id}")
    public ResponseEntity<ContratDto> getContratById(@PathVariable Long id) {
        Optional<Contrat> contrat = contratService.getContratById(id);
        return contrat.map(c -> ResponseEntity.ok(contratMapper.toDto(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllContrats")
    public ResponseEntity<List<ContratDto>> getAllContrats() {
        List<Contrat> contrats = contratService.getAllContrats();
        List<ContratDto> dtos = contrats.stream()
                .map(contratMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/close/{id}")
    public ResponseEntity<ContratDto> closeContrat(@PathVariable Long id) {
        Contrat closed = contratService.closeContrat(id);
        return ResponseEntity.ok(contratMapper.toDto(closed));
    }



}
