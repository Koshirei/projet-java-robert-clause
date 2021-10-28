package pojo;

import java.util.Objects;

public class Client {

    private int    id;
    private String nom;
    private String prenom;
    private String noRue;
    private String voie;
    private String codePostal;
    private String ville;
    private String pays;

    public Client(int id, String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNoRue(noRue);
        this.setVoie(voie);
        this.setCodePostal(codePostal);
        this.setVille(ville);
        this.setPays(pays);
    }

    public Client(String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNoRue(noRue);
        this.setVoie(voie);
        this.setCodePostal(codePostal);
        this.setVille(ville);
        this.setPays(pays);
    }

    public Client() {
        this.id = -1;
        this.nom = null;
        this.prenom = null;
        this.noRue = null;
        this.voie = null;
        this.codePostal = null;
        this.ville = null;
        this.pays = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNoRue() {
        return noRue;
    }

    public void setNoRue(String noRue) {
        this.noRue = noRue;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", noRue='" + noRue + '\'' +
                ", voie='" + voie + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(noRue, client.noRue) && Objects.equals(voie, client.voie) && Objects.equals(codePostal, client.codePostal) && Objects.equals(ville, client.ville) && Objects.equals(pays, client.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, noRue, voie, codePostal, ville, pays);
    }
}

