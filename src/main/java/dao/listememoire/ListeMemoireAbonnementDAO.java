package dao.listememoire;



import dao.AbonnementDAO;
import pojo.Abonnement;
import pojo.Periodicite;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {
    private static ListeMemoireAbonnementDAO instance;

    public ArrayList<Abonnement> donnees;

    private ListeMemoireAbonnementDAO() {
        this.donnees = new ArrayList<>();

        this.donnees.add(new Abonnement(1, 1 , "2" , new Date(0), new Date(0) ));
        this.donnees.add(new Abonnement(2, 1, "1" , new Date(0), new Date(0)) );
        this.donnees.add(new Abonnement(3, 2, "2", new Date(0), new Date(0) ));
        this.donnees.add(new Abonnement(4,1, "1", new Date(0), new Date(0) ));
    }

    public static ListeMemoireAbonnementDAO getInstance() {
        if (instance == null) {
            instance = new ListeMemoireAbonnementDAO();
        }

        return instance;
    }

    @Override
    public boolean creer(Abonnement objet) throws Exception {
        if (objet.getId() == -1) {
            objet.setId(5);

            while (this.donnees.contains(objet)) {
                objet.setId(objet.getId() + 1);

            }
        }

        if (objet.getNumeroClient() == -1 ||
                objet.getReferenceRevue() == null ||
                objet.getDateDebut() == null ||
                objet.getDateFin() == null) {

            throw new Exception("Une des valeurs n'est pas définie");
        }

        return this.donnees.add(objet);
    }

    @Override
    public boolean modifier(Abonnement object) throws IllegalArgumentException {
        int idx = this.donnees.indexOf(object);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            this.donnees.set(idx, object);
        }

        return true;
    }

    @Override
    public boolean supprimer(Abonnement objet) throws IllegalArgumentException {
        Abonnement supprime;

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public Abonnement getById(int id) throws IllegalArgumentException {
        int idx = this.donnees.indexOf(new Abonnement(id, 0,"ABC", null, null));

        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");

        } else {

            return this.donnees.get(idx);
        }
    }

    @Override
    public Abonnement getByNumeroClientAndReferenceRevue(int numeroClient, String referenceRevue) {
        return null;
    }

    @Override
    public List<Abonnement> getByNumeroClient(int numeroClient) {
        return null;
    }

    @Override
    public List<Abonnement> getByReferenceRevue(String referenceRevue) {
        return null;
    }

    @Override
    public List<Abonnement> getByDateDebut(Date dateDebut) {
        return null;
    }

    @Override
    public List<Abonnement> getByDateFin(Date dateFin) {
        return null;
    }
}

