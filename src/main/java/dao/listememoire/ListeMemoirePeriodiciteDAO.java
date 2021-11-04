package dao.listememoire;

import dao.PeriodiciteDAO;
import pojo.Periodicite;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {

    private static ListeMemoirePeriodiciteDAO instance;

    private List<Periodicite> donnees;


    public static ListeMemoirePeriodiciteDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoirePeriodiciteDAO();
        }

        return instance;
    }

    private ListeMemoirePeriodiciteDAO() {

        this.donnees = new ArrayList<Periodicite>();

        this.donnees.add(new Periodicite(1, "Mensuel"));
        this.donnees.add(new Periodicite(2, "Quotidien"));
    }


    @Override
    public boolean creer(Periodicite objet) {

        objet.setId(3);
        // Ne fonctionne que si l'objet m�tier est bien fait...
        while (this.donnees.contains(objet)) {

            objet.setId(objet.getId() + 1);
        }
        boolean ok = this.donnees.add(objet);

        return ok;
    }

    @Override
    public boolean modifier(Periodicite objet) {

        // Ne fonctionne que si l'objet m�tier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public List<Periodicite> findAll(Periodicite objet) throws SQLException, IOException {
        return null;
    }

    @Override
    public boolean supprimer(Periodicite objet) {

        Periodicite supprime;

        // Ne fonctionne que si l'objet m�tier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public Periodicite getById(int id) {
        // Ne fonctionne que si l'objet m�tier est bien fait...
        int idx = this.donnees.indexOf(new Periodicite(id, "test"));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }
}
