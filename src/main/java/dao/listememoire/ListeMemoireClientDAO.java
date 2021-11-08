package dao.listememoire;

import dao.ClientDAO;
import pojo.Abonnement;
import pojo.Client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireClientDAO implements ClientDAO {
    private static ListeMemoireClientDAO instance;

    public ArrayList<Client> donnees;

    private ListeMemoireClientDAO() {
        this.donnees = new ArrayList<>();

        this.donnees.add(new Client(1, "ROBERT", "Nicolas", "51", "B", "a", "a", "a"));
        this.donnees.add(new Client(2, "PASROBERT", "PASNicolas", "PAS51", "PASB", "PASa", "PASa", "PASa"));
        this.donnees.add(new Client(3, "NONROBERT", "NONNicolas", "NON51", "NONB", "NONa", "NONa", "NONa"));

    }

    public static ListeMemoireClientDAO getInstance() {
        if (instance == null) {
            instance = new ListeMemoireClientDAO();
        }

        return instance;
    }


    @Override
    public boolean creer(Client objet) throws Exception {
        if (objet.getId() == -1) {
            objet.setId(5);

            while (this.donnees.contains(objet)) {
                objet.setId(objet.getId() + 1);

            }
        }

        if (objet.getNom() == null ||
                objet.getPrenom() == null ||
                objet.getNoRue() == null ||
                objet.getVoie() == null ||
                objet.getCodePostal() == null ||
                objet.getVille() == null ||
                objet.getPays() == null) {

            throw new Exception("Une des valeurs n'est pas définie");

        }

        return this.donnees.add(objet);

    }

    @Override
    public boolean modifier(Client object) throws IllegalArgumentException {
        int idx = this.donnees.indexOf(object);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            this.donnees.set(idx, object);
        }

        return true;
    }


    @Override
    public boolean supprimer(Client objet) throws IllegalArgumentException {
        Client supprime;

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public Client getById(int id) throws IllegalArgumentException {
        int idx = this.donnees.indexOf(new Client(id, "ABC", "DEF", "123", "GHI", "456", "JKL", "MNO"));

        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");

        } else {

            return this.donnees.get(idx);
        }

    }

}
