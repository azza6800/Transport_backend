package stage.example.Transport.Dto;

import stage.example.Transport.Entite.Role;
import stage.example.Transport.Entite.TypeDocument;
import java.util.List;

public class UserDto {


    private Long id;
    private String username;
    private String motDePasse;
    private String email;
    private Role role;
    private boolean actif;
    private String nom;
    private String prenom;

    private List<Long> agenceIds;
    private List<Long> contratIds;

    private TypeDocument typeDocument;
    private String numeroDocument;
    private String raisonSociale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Long> getAgenceIds() {
        return agenceIds;
    }

    public void setAgenceIds(List<Long> agenceIds) {
        this.agenceIds = agenceIds;
    }

    public List<Long> getContratIds() {
        return contratIds;
    }

    public void setContratIds(List<Long> contratIds) {
        this.contratIds = contratIds;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getNumeroDocument() {
        return numeroDocument;
    }

    public void setNumeroDocument(String numeroDocument) {
        this.numeroDocument = numeroDocument;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
}
