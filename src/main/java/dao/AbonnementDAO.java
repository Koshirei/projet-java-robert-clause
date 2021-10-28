package dao;

import pojo.Abonnement;

import java.sql.Date;
import java.util.List;

public interface AbonnementDAO extends DAO<Abonnement> {
    public Abonnement getByNumeroClientAndReferenceRevue(int numeroClient, String referenceRevue);
    public List<Abonnement> getByNumeroClient(int numeroClient);
    public List<Abonnement> getByReferenceRevue(String referenceRevue);
    public List<Abonnement> getByDateDebut(Date dateDebut);
    public List<Abonnement> getByDateFin(Date dateFin);
}
