package stage.example.Transport.Services;

import stage.example.Transport.Entite.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getUsersByRole(String role);

    List<User> getUsersByAgenceAndRole(Long numAgence, String role);
}

