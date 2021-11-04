package dao.listememoire;

import dao.ClientDAO;
import pojo.Client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireClientDAO implements ClientDAO {
    private static ListeMemoireClientDAO instance;

    public ArrayList<Client> donnees;

    private ListeMemoireClientDAO() {
        donnees = new ArrayList<>();

        donnees.add(new Client(1, "ROBERT", "Nicolas", "51", "B", "a", "a", "a"));
        donnees.add(new Client(2, "PASROBERT", "PASNicolas", "PAS51", "PASB", "PASa", "PASa", "PASa"));

        donnees.add(new Client(3, "NONROBERT", "NONNicolas", "NON51", "NONB", "NONa", "NONa", "NONa"));

    }

    public static ListeMemoireClientDAO getInstance() {
        if (instance == null) {
            instance = new ListeMemoireClientDAO();
        }

        return instance;
    }



    @Override
    public boolean creer(Client objet) {
        objet.setId(4);

        while (this.donnees.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }

        return this.donnees.add(objet);
    }

    @Override
    public boolean modifier(Client object) {
        int idx = this.donnees.indexOf(object);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            this.donnees.set(idx, object);
        }

        return true;
    }

    @Override
    public List<Client> findAll(Client objet) throws SQLException, IOException {
        return null;
    }

    @Override
    public boolean supprimer(Client objet) {
        Client supprime;

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }



    /*@Override
    public ArrayList<Client> findAll() {
        return this.donnees;
    }*/

    @Override
    public Client getById(int id) {
        return null;
    }

}
