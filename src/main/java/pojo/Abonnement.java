package pojo;

import java.sql.Date;
import java.util.Objects;

public class Abonnement {
    private int numeroClient;
    private String referenceRevue;
    private Date dateDebut;
    private Date dateFin;

    public Abonnement(int numeroClient, String referenceRevue, Date dateDebut, Date dateFin) {
        this.setNumeroClient(numeroClient);
        this.setReferenceRevue(referenceRevue);
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
    }

    public int getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(int numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getReferenceRevue() {
        return referenceRevue;
    }

    public void setReferenceRevue(String referenceRevue) {
        referenceRevue = referenceRevue.trim();
        referenceRevue = referenceRevue.replaceAll(" ", "");
        referenceRevue = referenceRevue.toUpperCase();

        this.referenceRevue = referenceRevue;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonnement that = (Abonnement) o;
        return numeroClient == that.numeroClient && Objects.equals(referenceRevue, that.referenceRevue) && Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroClient, referenceRevue, dateDebut, dateFin);
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "numeroClient=" + numeroClient +
                ", referenceRevue='" + referenceRevue + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
