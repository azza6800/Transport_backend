package stage.example.Transport.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import stage.example.Transport.Entite.TypeDocument;
import stage.example.Transport.Entite.User;
import stage.example.Transport.Repository.UserRepository;
import stage.example.Transport.Services.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            updateField(user, "username", updatedUser.getUsername());
            updateField(user, "email", updatedUser.getEmail());
            updateField(user, "motDePasse", updatedUser.getMotDePasse());
            updateField(user, "role", updatedUser.getRole());
            updateField(user, "nom", updatedUser.getNom());
            updateField(user, "prenom", updatedUser.getPrenom());
            updateField(user, "numAgence", updatedUser.getNumAgence());
            updateField(user, "typeDocument", updatedUser.getTypeDocument());
            updateField(user, "numeroDocument", updatedUser.getNumeroDocument());
            updateField(user, "raisonSociale", updatedUser.getRaisonSociale());
            updateField(user, "actif", updatedUser.isActif());

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));
    }
    private void updateField(User user, String field, Object value) {
        if (value == null) return;
        switch (field) {
            case "username" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setUsername(val);
            }
            case "email" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setEmail(val);
            }
            case "motDePasse" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setMotDePasse(val);
            }
            case "role" -> user.setRole((String) value);
            case "nom" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setNom(val);
            }
            case "prenom" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setPrenom(val);
            }
            case "numAgence" -> user.setNumAgence((Long) value);
            case "typeDocument" -> {
                TypeDocument val = (TypeDocument) value;
                if (!val.describeConstable().isEmpty()) user.setTypeDocument(val);
            }
            case "numeroDocument" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setNumeroDocument(val);
            }
            case "raisonSociale" -> {
                String val = (String) value;
                if (!val.isBlank()) user.setRaisonSociale(val);
            }
            case "actif" -> user.setActif((Boolean) value);
            default -> {
                // rien à faire
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID : " + id);
        }
        userRepository.deleteById(id);
    }
    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role.toUpperCase());
    }
    public void setUserActif(Long id, boolean actif) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setActif(actif);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec l'id " + id);
        }
    }
    @Override
    public List<User> getUsersByAgenceAndRole(Long numAgence, String role) {
        return userRepository.findByNumAgenceAndRole(numAgence, role);
    }
    public Page<User> searchClients(String keyword, Pageable pageable) {
        return userRepository.findByRoleAndNomContainingIgnoreCaseOrRoleAndPrenomContainingIgnoreCaseOrRoleAndEmailContainingIgnoreCase(
                "CLIENT", keyword,
                "CLIENT", keyword,
                "CLIENT", keyword,
                pageable
        );
    }
}

