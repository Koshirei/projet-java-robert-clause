package dao.mysql;

import dao.AbonnementDAO;
import dao.ConnexionMySQL;
import pojo.Abonnement;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class MySQLAbonnementDAO implements AbonnementDAO {
    private static MySQLAbonnementDAO instance;

    private MySQLAbonnementDAO() {}

    public static MySQLAbonnementDAO getInstance() {
        if (instance == null) {
            instance = new MySQLAbonnementDAO();
        }

        return instance;
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

    @Override
    public Abonnement getById(int id) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "select * from Abonnement where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, id);

        ResultSet resultSet = prepareStatement.executeQuery();

        Abonnement abonnement = new Abonnement();

        while (resultSet.next()) {
            abonnement.setId(resultSet.getInt("id"));
            abonnement.setNumeroClient(resultSet.getInt("numeroClient"));
            abonnement.setReferenceRevue(resultSet.getString("referenceRevue"));
            abonnement.setDateDebut(resultSet.getDate("dateDebut"));
            abonnement.setDateFin(resultSet.getDate("dateFin"));
        }

        connection.close();

        return abonnement;
    }

    @Override
    public boolean supprimer(Abonnement objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "delete from Abonnement where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean creer(Abonnement objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "insert into Abonnement (numeroClient, referenceRevue, dateDebut, dateFin) values (?, ?, ?, ?)";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getNumeroClient());
        prepareStatement.setString(2, objet.getReferenceRevue());
        prepareStatement.setDate(3, objet.getDateDebut());
        prepareStatement.setDate(4, objet.getDateFin());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean modifier(Abonnement objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "update Abonnement set numeroClient = ?, referenceRevue = ?, dateDebut = ?, dateFin = ? where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getNumeroClient());
        prepareStatement.setString(2, objet.getReferenceRevue());
        prepareStatement.setDate(3, objet.getDateDebut());
        prepareStatement.setDate(4, objet.getDateFin());
        prepareStatement.setInt(5, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }
}
