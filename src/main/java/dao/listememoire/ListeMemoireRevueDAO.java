package dao.listememoire;

import dao.RevueDAO;
import pojo.Revue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireRevueDAO implements RevueDAO {
    private static ListeMemoireRevueDAO instance;

    private ArrayList<Revue> listeRevues;


    private ListeMemoireRevueDAO() throws Exception {
        listeRevues = new ArrayList<>();

        listeRevues.add(new Revue(1, "Tintin", "et milou", "visuel",  9.90f, "1"));
        listeRevues.add(new Revue(2, "HOmer", "Simpson", "visuel2", 15.90f, "2"));
        listeRevues.add(new Revue(3, "Belgique", "Frites", "visuel3", 4.90f, "2"));


    }


    public static ListeMemoireRevueDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new ListeMemoireRevueDAO();
        }

        return instance;
    }

    @Override
    public boolean creer(Revue objet) {
        objet.setId(4);

        while (this.listeRevues.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }

        return this.listeRevues.add(objet);
    }

    @Override
    public boolean modifier(Revue object) {
        int idx = this.listeRevues.indexOf(object);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            this.listeRevues.set(idx, object);
        }

        return true;
    }

    @Override
    public List<Revue> findAll(Revue objet) throws SQLException, IOException {
        return null;
    }

    @Override
    public Revue getById(int id) throws Exception {
        return null;
    }

    @Override
    public boolean supprimer(Revue objet) {
        Revue supprime;

        int idx = this.listeRevues.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            supprime = this.listeRevues.remove(idx);
        }

        return objet.equals(supprime);
    }

    /*@Override
    public ArrayList<Revue> findAll() {
        return this.listeRevues;
    }*/


}
