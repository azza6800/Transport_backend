package stage.example.Transport.Entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agence
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long codeAgence ;
    @ManyToMany(mappedBy = "agences")
    private List<User> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(Long codeAgence) {
        this.codeAgence = codeAgence;
    }

    public List<User> getClients() {
        return clients;
    }

    public void setClients(List<User> clients) {
        this.clients = clients;
    }
}
