package dao.mysql;

import dao.ConnexionMySQL;
import dao.PeriodiciteDAO;
import pojo.Client;
import pojo.Periodicite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO {
    @Override
    public Periodicite getById(int id) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "select * from Periodicite where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, id);

        ResultSet resultSet = prepareStatement.executeQuery();

        Periodicite periodicite = new Periodicite();

        while (resultSet.next()) {
            periodicite.setId(resultSet.getInt("id"));
            periodicite.setLibelle(resultSet.getString("libelle"));
        }

        connection.close();

        return periodicite;
    }

    @Override
    public boolean supprimer(Periodicite objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "delete from Periodicite where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean creer(Periodicite objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "insert into Periodicite (libelle) values (?)";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, objet.getLibelle());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean modifier(Periodicite objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "update Periodicite set libelle = ? where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, objet.getLibelle());
        prepareStatement.setInt(2, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }
}
