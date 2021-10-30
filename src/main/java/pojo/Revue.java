package pojo;

import java.util.Objects;

public class Revue {
    private int id;
    private String reference;
    private String titre;
    private String description;
    private float tarif;
    private String periodicite; // enum ??

    public Revue(int id, String reference, String titre, String description, float tarif, String periodicite) throws Exception {
        this.setReference(reference);
        this.setTitre(titre);
        this.setDescription(description);
        this.setTarif(tarif);
        this.setPeriodicite(periodicite);
    }

    public Revue(String reference, String titre, String description, float tarif, String periodicite) throws Exception {
        this.setReference(reference);
        this.setTitre(titre);
        this.setDescription(description);
        this.setTarif(tarif);
        this.setPeriodicite(periodicite);
    }

    public Revue() throws Exception {
        this.id = -1;
        this.reference = null;
        this.titre = null;
        this.description = null;
        this.tarif = -1.0f;
        this.periodicite = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        reference = reference.trim();
        reference = reference.replaceAll(" ", "");
        reference = reference.toUpperCase();

        this.reference = reference;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        titre = titre.trim();

        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) throws Exception {
        description = description.trim();

        if (description.length() > 400) {
            throw new Exception("Description trop longue ! Elle doit faire moins de 400 caractères.");
        }

        this.description = description;
    }

    public float getTarif() {
        return this.tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getPeriodicite() {
        return this.periodicite;
    }

    public void setPeriodicite(String periodicite) {
        periodicite = periodicite.trim();

        this.periodicite = periodicite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revue revue = (Revue) o;
        return Float.compare(revue.tarif, tarif) == 0 && Objects.equals(reference, revue.reference) && Objects.equals(titre, revue.titre) && Objects.equals(description, revue.description) && Objects.equals(periodicite, revue.periodicite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, titre, description, tarif, periodicite);
    }

    @Override
    public String toString() {
        return "Revue{" +
                "reference='" + reference + '\'' +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", tarif=" + tarif +
                ", periodicite='" + periodicite + '\'' +
                '}';
    }
}
