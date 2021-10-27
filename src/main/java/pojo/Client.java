package pojo;

import java.util.Objects;

public class Client {

    private int    id;
    private String nom;
    private String prenom;
    private String no_rue;
    private String voie;
    private String code_postal;
    private String ville;
    private String pays;

    public Client(int id, String nom, String prenom, String no_rue, String voie, String code_postal, String ville, String pays) {
        this.id = id;
        this.nom = nom.trim();
        this.prenom = prenom.trim();
        this.no_rue = no_rue.trim();
        this.voie = voie.trim();
        this.code_postal = code_postal.trim();
        this.ville = ville.trim();
        this.pays = pays.trim();
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

    public String getNo_rue() {
        return no_rue;
    }

    public void setNo_rue(String no_rue) {
        this.no_rue = no_rue;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
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
                ", no_rue='" + no_rue + '\'' +
                ", voie='" + voie + '\'' +
                ", code_postal='" + code_postal + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(no_rue, client.no_rue) && Objects.equals(voie, client.voie) && Objects.equals(code_postal, client.code_postal) && Objects.equals(ville, client.ville) && Objects.equals(pays, client.pays);
    }

}

