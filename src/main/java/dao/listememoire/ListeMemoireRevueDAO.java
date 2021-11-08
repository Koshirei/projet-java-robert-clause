package dao.listememoire;

import dao.RevueDAO;
import pojo.Revue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireRevueDAO implements RevueDAO {
    private static ListeMemoireRevueDAO instance;

    private ArrayList<Revue> donnees;


    private ListeMemoireRevueDAO() throws Exception {
        this.donnees = new ArrayList<>();

        this.donnees.add(new Revue(1, "Tintin", "et milou", "visuel",  9.90f, "1"));
        this.donnees.add(new Revue(2, "HOmer", "Simpson", "visuel2", 15.90f, "2"));
        this.donnees.add(new Revue(3, "Belgique", "Frites", "visuel3", 4.90f, "2"));

    }

    public static ListeMemoireRevueDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new ListeMemoireRevueDAO();
        }

        return instance;
    }

    @Override
    public boolean creer(Revue objet) throws Exception {
        if (objet.getId()==-1) {
            objet.setId(5);

            while (this.donnees.contains(objet)) {
                objet.setId(objet.getId() + 1);
            }
        }

        if(objet.getReference()==null ||
                objet.getTitre()==null ||
                objet.getDescription()==null ||
                objet.getTarif()== 0.0 ||
                objet.getPeriodicite()==null ){

            throw new Exception("Une des valeurs n'est pas définie");
        }
        return this.donnees.add(objet);
    }

    @Override
    public boolean modifier(Revue object) throws IllegalArgumentException{
        int idx = this.donnees.indexOf(object);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            this.donnees.set(idx, object);
        }

        return true;
    }

    @Override
    public Revue getById(int id) throws Exception {
        int idx = this.donnees.indexOf(new Revue(id, "ABC", "DEF" , "GHI", 0.0f , "JKL"));

        if (idx == -1){
            throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
        }
        else{
            return this.donnees.get(idx);
        }
    }

    @Override
    public boolean supprimer(Revue objet) throws IllegalArgumentException{
        Revue supprime;

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }



}
