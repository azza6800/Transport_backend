package stage.example.Transport.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import stage.example.Transport.Entite.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);
    List<User> findByNumAgenceAndRole(Long numAgence, String role);
    Page<User> findByRoleAndNomContainingIgnoreCaseOrRoleAndPrenomContainingIgnoreCaseOrRoleAndEmailContainingIgnoreCase(
            String role1, String nom,
            String role2, String prenom,
            String role3, String email,
            Pageable pageable);

}
