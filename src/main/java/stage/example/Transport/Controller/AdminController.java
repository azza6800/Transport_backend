package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stage.example.Transport.Dto.UserDto;
import stage.example.Transport.Entite.Role;
import stage.example.Transport.Entite.User;
import stage.example.Transport.Mapper.UserMapper;
import stage.example.Transport.Services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    // ✅ Récupérer tous les clients
    @GetMapping("/getAllClients")
    public ResponseEntity<List<UserDto>> getAllClients() {
        List<UserDto> clients = userService.getUsersByRole("CLIENT")
                .stream().map(userMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }

    // ✅ Créer un client
    @PostMapping("/createClient")
    public ResponseEntity<UserDto> createClient(@RequestBody UserDto userDto) {
        userDto.setRole(Role.CLIENT);
        User user = userMapper.toEntity(userDto);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(userMapper.toDto(savedUser));
    }

    // ✅ Récupérer un client par ID
    @GetMapping("/getClientById/{id}")
    public ResponseEntity<UserDto> getClientById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(userMapper.toDto(user));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Activer / désactiver un client
    @PutMapping("/toggleClientActif/{id}")
    public ResponseEntity<Void> toggleClientActivation(@PathVariable Long id) {
        User user = userService.getUserById(id);
        user.setActif(!user.isActif());
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    // ✅ Mettre à jour un client
    @PutMapping("/updateClient/{id}")
    public ResponseEntity<UserDto> updateClient(@PathVariable Long id, @RequestBody UserDto updatedDto) {
        User updatedUser = userMapper.toEntity(updatedDto);
        User saved = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userMapper.toDto(saved));
    }

    // ✅ Lister les clients d’une agence
    @GetMapping("/getClientsByAgence/{numAgence}")
    public ResponseEntity<List<UserDto>> getClientsByAgence(@PathVariable Long numAgence) {
        List<UserDto> clients = userService.getUsersByAgenceAndRole(numAgence, "CLIENT")
                .stream().map(userMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }
}
