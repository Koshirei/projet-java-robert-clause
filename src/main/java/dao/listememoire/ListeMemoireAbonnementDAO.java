package dao.listememoire;

import dao.AbonnementDAO;
import pojo.Abonnement;

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
    public boolean creer(Abonnement objet) {
        objet.setId(5);


        while (this.donnees.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }

        return this.donnees.add(objet);
    }

    @Override
    public boolean modifier(Abonnement object) {
        int idx = this.donnees.indexOf(object);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            this.donnees.set(idx, object);
        }

        return true;
    }

    @Override
    public List<Abonnement> findAll(Abonnement objet) throws SQLException, IOException {
        return null;
    }

    @Override
    public boolean supprimer(Abonnement objet) {
        Abonnement supprime;

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    /*@Override
    public ArrayList<Abonnement> findAll() {
        return this.donnees;
    }*/

    @Override
    public Abonnement getById(int id) {
        return null;
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
    public List<Abonnement> getByDateDebut(Date date) {
        return null;
    }

    @Override
    public List<Abonnement> getByDateFin(Date date) {
        return null;
    }


}

