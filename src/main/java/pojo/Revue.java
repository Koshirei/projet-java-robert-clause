package pojo;

public class Revue {
    private String reference;
    private String titre;
    private String description;
    private float tarif;
    private String periodicite; // enum ??

    public Revue(String reference, String titre, String description, float tarif, String periodicite) throws Exception {
        this.setReference(reference);
        this.setTitre(titre);
        this.setDescription(description);
        this.setTarif(tarif);
        this.setPeriodicite(periodicite);
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
}
