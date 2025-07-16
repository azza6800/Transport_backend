package stage.example.Transport.Entite;

import jakarta.persistence.*;
import org.aspectj.weaver.loadtime.Agent;

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
    private float valeurFacture;
    private String deviseFacture;
    private float valeurTotale;
    private float valeurMarchandise;
    private float valeurAutre;
    private String provenance;
    private String lieuDepart;
    private String lieuDestination;
    private String moyenTransp;
    private String conditions;

    @Temporal(TemporalType.DATE)
    private Date dateEffet;


    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    private String commentaireAgent;

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

    public float getValeurFacture() {
        return valeurFacture;
    }

    public void setValeurFacture(float valeurFacture) {
        this.valeurFacture = valeurFacture;
    }

    public String getDeviseFacture() {
        return deviseFacture;
    }

    public void setDeviseFacture(String deviseFacture) {
        this.deviseFacture = deviseFacture;
    }

    public float getValeurTotale() {
        return valeurTotale;
    }

    public void setValeurTotale(float valeurTotale) {
        this.valeurTotale = valeurTotale;
    }

    public float getValeurMarchandise() {
        return valeurMarchandise;
    }

    public void setValeurMarchandise(float valeurMarchandise) {
        this.valeurMarchandise = valeurMarchandise;
    }

    public float getValeurAutre() {
        return valeurAutre;
    }

    public void setValeurAutre(float valeurAutre) {
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

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
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
