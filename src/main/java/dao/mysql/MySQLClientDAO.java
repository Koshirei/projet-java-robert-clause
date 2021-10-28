package dao.mysql;

import dao.ClientDAO;
import dao.ConnexionMySQL;
import pojo.Abonnement;
import pojo.Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLClientDAO implements ClientDAO {

    @Override
    public Client getById(int id) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "select * from Client where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, id);

        ResultSet resultSet = prepareStatement.executeQuery();

        Client client = new Client();

        while (resultSet.next()) {
            client.setId(resultSet.getInt("id"));
            client.setNom(resultSet.getString("nom"));
            client.setPrenom(resultSet.getString("prenom"));
            client.setNoRue(resultSet.getString("noRue"));
            client.setVoie(resultSet.getString("voie"));
            client.setCodePostal(resultSet.getString("codePostal"));
            client.setVille(resultSet.getString("ville"));
            client.setPays(resultSet.getString("pays"));
        }

        connection.close();

        return client;
    }

    @Override
    public boolean supprimer(Client objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "delete from Client where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean creer(Client objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "insert into Client (nom, prenom, noRue, voie, codePostal, ville, pays) values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, objet.getNom());
        prepareStatement.setString(2, objet.getPrenom());
        prepareStatement.setString(3, objet.getNoRue());
        prepareStatement.setString(4, objet.getVoie());
        prepareStatement.setString(5, objet.getCodePostal());
        prepareStatement.setString(6, objet.getVille());
        prepareStatement.setString(7, objet.getPays());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }

    @Override
    public boolean modifier(Client objet) throws SQLException, IOException {
        Connection connection = ConnexionMySQL.getInstance().creeConnexion();

        String sql = "update Client set nom = ?, prenom = ?, noRue = ?, voie = ?, codePostal = ?, ville= ?, pays = ? where id = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, objet.getNom());
        prepareStatement.setString(2, objet.getPrenom());
        prepareStatement.setString(3, objet.getNoRue());
        prepareStatement.setString(4, objet.getVoie());
        prepareStatement.setString(5, objet.getCodePostal());
        prepareStatement.setString(6, objet.getVille());
        prepareStatement.setString(7, objet.getPays());
        prepareStatement.setInt(8, objet.getId());

        boolean nombreLigne = prepareStatement.executeUpdate() == 1;

        connection.close();

        return nombreLigne;
    }
}
