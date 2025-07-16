package stage.example.Transport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.example.Transport.Dto.UserDto;
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

    @GetMapping("/getAllClients")
    public ResponseEntity<List<UserDto>> getAllClients() {
        List<UserDto> clients = userService.getUsersByRole("CLIENT")
                .stream().map(userMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/createClient")
    public UserDto createClient(@RequestBody UserDto userDto) {
        userDto.setRole("CLIENT");
        User saved = userService.createUser(userMapper.toEntity(userDto));
        return userMapper.toDto(saved);
    }

    @GetMapping("/getClientById/{id}")
    public ResponseEntity<UserDto> getClientById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(userMapper.toDto(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/toggleClientActif/{id}")
    public ResponseEntity<Void> toggleClientActivation(@PathVariable Long id) {
        User user = userService.getUserById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        userService.setUserActif(id, !user.isActif());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateClient/{id}")
    public ResponseEntity<UserDto> updateClient(@PathVariable Long id, @RequestBody UserDto updatedDto) {
        User updatedUser = userMapper.toEntity(updatedDto);
        User saved = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userMapper.toDto(saved));
    }

    @GetMapping("/getClientsByAgence/{numAgence}")
    public List<UserDto> getClientsByAgence(@PathVariable Long numAgence) {
        return userService.getUsersByAgenceAndRole(numAgence, "CLIENT")
                .stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public ResponseEntity<Page<UserDto>> searchClients(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> resultPage = userService.searchClients(keyword, pageRequest);
        Page<UserDto> dtoPage = resultPage.map(userMapper::toDto);
        return ResponseEntity.ok(dtoPage);
    }
}
