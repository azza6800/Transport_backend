package stage.example.Transport.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stage.example.Transport.Entite.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    User saveUser(User user);

    User updateUser(Long id, User updatedUser);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();

    List<User> getUsersByRole(String role);

    Optional<User> getUserByEmail(String email);

    List<User> getUsersByAgenceAndRole(Long codeAgence, String role);
}

