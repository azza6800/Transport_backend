package stage.example.Transport.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import stage.example.Transport.Entite.StatutContrat;
import stage.example.Transport.Entite.TypeContrat;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class ContratDto {

    private TypeContrat typeContrat;
    private StatutContrat statut;
    private Date dateEffet;
    private Date dateDelivrance;
    private Date dateFin;
    private Long clientId;
    private List<Long> demandeIds;

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public StatutContrat getStatut() {
        return statut;
    }

    public void setStatut(StatutContrat statut) {
        this.statut = statut;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getDemandeIds() {
        return demandeIds;
    }

    public void setDemandeIds(List<Long> demandeIds) {
        this.demandeIds = demandeIds;
    }
}

