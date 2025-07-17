package stage.example.Transport.Dto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import stage.example.Transport.Entite.StatutDemande;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDto {
    private Long id;
    private Long contratId;

    private Long avisAliment;
    private String description;
    private Long refFacture;
    private Long refTransp;
    private BigDecimal valeurFacture;

    private String deviseFacture;
    private BigDecimal valeurTotale;
    private BigDecimal valeurMarchandise;
    private BigDecimal valeurAutre;
    private String provenance;
    private String lieuDepart;
    private String lieuDestination;
    private String moyenTransp;
    private String conditions;

    private LocalDate dateEffet;

    private Long agentValidateurId;

    private StatutDemande statut;

    private String commentaireAgent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContratId() {
        return contratId;
    }

    public void setContratId(Long contratId) {
        this.contratId = contratId;
    }

    public Long getAvisAliment() {
        return avisAliment;
    }

    public void setAvisAliment(Long avisAliment) {
        this.avisAliment = avisAliment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRefFacture() {
        return refFacture;
    }

    public void setRefFacture(Long refFacture) {
        this.refFacture = refFacture;
    }

    public Long getRefTransp() {
        return refTransp;
    }

    public void setRefTransp(Long refTransp) {
        this.refTransp = refTransp;
    }

    public BigDecimal getValeurFacture() {
        return valeurFacture;
    }

    public void setValeurFacture(BigDecimal valeurFacture) {
        this.valeurFacture = valeurFacture;
    }

    public String getDeviseFacture() {
        return deviseFacture;
    }

    public void setDeviseFacture(String deviseFacture) {
        this.deviseFacture = deviseFacture;
    }

    public BigDecimal getValeurTotale() {
        return valeurTotale;
    }

    public void setValeurTotale(BigDecimal valeurTotale) {
        this.valeurTotale = valeurTotale;
    }

    public BigDecimal getValeurMarchandise() {
        return valeurMarchandise;
    }

    public void setValeurMarchandise(BigDecimal valeurMarchandise) {
        this.valeurMarchandise = valeurMarchandise;
    }

    public BigDecimal getValeurAutre() {
        return valeurAutre;
    }

    public void setValeurAutre(BigDecimal valeurAutre) {
        this.valeurAutre = valeurAutre;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuDestination() {
        return lieuDestination;
    }

    public void setLieuDestination(String lieuDestination) {
        this.lieuDestination = lieuDestination;
    }

    public String getMoyenTransp() {
        return moyenTransp;
    }

    public void setMoyenTransp(String moyenTransp) {
        this.moyenTransp = moyenTransp;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public LocalDate getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(LocalDate dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Long getAgentValidateurId() {
        return agentValidateurId;
    }

    public void setAgentValidateurId(Long agentValidateurId) {
        this.agentValidateurId = agentValidateurId;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }

    public String getCommentaireAgent() {
        return commentaireAgent;
    }

    public void setCommentaireAgent(String commentaireAgent) {
        this.commentaireAgent = commentaireAgent;
    }
}
