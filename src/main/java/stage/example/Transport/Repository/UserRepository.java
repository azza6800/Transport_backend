package stage.example.Transport.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import stage.example.Transport.Entite.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);

    Optional<User> findByEmail(String email);
    List<User> findByAgences_CodeAgenceAndRole(Long codeAgence, String role);


}
