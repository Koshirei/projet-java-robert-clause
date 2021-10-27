package pojo;

import java.util.Objects;

public class Periodicite {
    private int id;
    private String libelle;

    public Periodicite(int i, String l){
        this.id=i;
        this.libelle=l.trim();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle.trim();
    }

    @Override
    public String toString() {
        return "Periodicite{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodicite that = (Periodicite) o;
        return id == that.id && Objects.equals(libelle, that.libelle);
    }


}
