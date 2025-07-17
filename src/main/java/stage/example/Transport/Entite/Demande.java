package stage.example.Transport.Entite;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;


    private long avisAliment;
    private String description;
    private long refFacture;
    private long refTransp;
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

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agentValidateur;


    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    private String commentaireAgent;

    public LocalDate getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(LocalDate dateEffet) {
        this.dateEffet = dateEffet;
    }

    public User getAgentValidateur() {
        return agentValidateur;
    }

    public void setAgentValidateur(User agentValidateur) {
        this.agentValidateur = agentValidateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public long getAvisAliment() {
        return avisAliment;
    }

    public void setAvisAliment(long avisAliment) {
        this.avisAliment = avisAliment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRefFacture() {
        return refFacture;
    }

    public void setRefFacture(long refFacture) {
        this.refFacture = refFacture;
    }

    public long getRefTransp() {
        return refTransp;
    }

    public void setRefTransp(long refTransp) {
        this.refTransp = refTransp;
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

    public BigDecimal getValeurFacture() {
        return valeurFacture;
    }

    public void setValeurFacture(BigDecimal valeurFacture) {
        this.valeurFacture = valeurFacture;
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
