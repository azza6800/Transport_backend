package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.example.Transport.Dto.ContratDto;
import stage.example.Transport.Entite.Contrat;
import stage.example.Transport.Mapper.ContratMapper;
import stage.example.Transport.Services.ContratService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contrats")
public class ContratController {

}
