package dao.mysql;

import dao.ConnexionMySQL;
import dao.RevueDAO;
import pojo.Abonnement;
import pojo.Periodicite;
import pojo.Revue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRevueDAO implements RevueDAO {
    private static MySQLRevueDAO instance;

    private MySQLRevueDAO() {}

    public static MySQLRevueDAO getInstance() {
        if (instance == null) {
            instance = new MySQLRevueDAO();
        }

        return instance;
    }

    @Override
    public Revue getById(int id) throws Exception {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "select * from Revue where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, id);

        ResultSet resultSet = prepareStatement.executeQuery();

        Revue revue = new Revue();

        while (resultSet.next()) {
            revue.setId(resultSet.getInt("id"));
            revue.setReference(resultSet.getString("reference"));
            revue.setTitre(resultSet.getString("titre"));
            revue.setDescription(resultSet.getString("description"));
            revue.setTarif(resultSet.getFloat("tarif"));
            revue.setPeriodicite(resultSet.getString("periodicite"));
        }

        connection.close();

        return revue;
    }

    @Override
    public boolean supprimer(Revue objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "delete from Revue where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean creer(Revue objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "insert into Revue (id, reference, titre, description, tarif, periodicite) values (?, ?, ?, ?, ?, ?)";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getId());
        prepareStatement.setString(2, objet.getReference());
        prepareStatement.setString(3, objet.getTitre());
        prepareStatement.setString(4, objet.getDescription());
        prepareStatement.setFloat(5, objet.getTarif());
        prepareStatement.setString(6, objet.getPeriodicite());

        if (objet.getId() == 1) {
            sql = "insert into Revue (reference, titre, description, tarif, periodicite) values (?, ?, ?, ?, ?)";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, objet.getReference());
            prepareStatement.setString(2, objet.getTitre());
            prepareStatement.setString(3, objet.getDescription());
            prepareStatement.setFloat(4, objet.getTarif());
            prepareStatement.setString(5, objet.getPeriodicite());
        }

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean modifier(Revue objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "update Revue set reference = ?, titre = ?, description = ?, tarif = ?, periodicite = ? where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, objet.getReference());
        prepareStatement.setString(2, objet.getTitre());
        prepareStatement.setString(3, objet.getDescription());
        prepareStatement.setFloat(4, objet.getTarif());
        prepareStatement.setString(5, objet.getPeriodicite());
        prepareStatement.setInt(6, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }
}
