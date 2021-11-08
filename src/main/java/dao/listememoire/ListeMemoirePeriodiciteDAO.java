package dao.listememoire;

import dao.PeriodiciteDAO;
import pojo.Periodicite;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {
    private static ListeMemoirePeriodiciteDAO instance;

    private ArrayList<Periodicite> donnees;

    private ListeMemoirePeriodiciteDAO() {
        this.donnees = new ArrayList<>();

        this.donnees.add(new Periodicite(1, "Quotidien"));
        this.donnees.add(new Periodicite(2, "Hebdomadaire"));
        this.donnees.add(new Periodicite(3, "Mensuel"));
        this.donnees.add(new Periodicite(4, "Annuel"));
    }


    public static ListeMemoirePeriodiciteDAO getInstance() {

        if (instance == null) {
            instance = new ListeMemoirePeriodiciteDAO();
        }

        return instance;
    }




    @Override
    public boolean creer(Periodicite objet) throws Exception {
        if (objet.getId() == -1) {
            objet.setId(5);

            while (this.donnees.contains(objet)) {
                objet.setId(objet.getId() + 1);
            }
        }

        if(objet.getLibelle()==null){
            throw new Exception("Une des valeurs n'est pas définie");
        }

        return this.donnees.add(objet);
    }

    @Override
    public boolean modifier(Periodicite objet) throws IllegalArgumentException {

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
        } else {

            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean supprimer(Periodicite objet) throws IllegalArgumentException {

        Periodicite supprime;

        int idx = this.donnees.indexOf(objet);

        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
        } else {
            supprime = this.donnees.remove(idx);
        }

        return objet.equals(supprime);
    }

    @Override
    public Periodicite getById(int id) throws IllegalArgumentException {

        int idx = this.donnees.indexOf(new Periodicite(id, "test"));

        if (idx == -1) {
            throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }
}
