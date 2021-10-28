package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnexionMySQL {
    private static ConnexionMySQL instance;
    private Connection connexion;

    private ConnexionMySQL() {}

    public static ConnexionMySQL getInstance() {
        if (instance == null) {
            instance = new ConnexionMySQL();
        }

        return instance;
    }

    public Connection creeConnexion() throws IOException, SQLException {
        Properties accesBdd = new Properties();
        File fBdd = new File( "src/main/resources/Properties.xml");

        try {
            FileInputStream source = new FileInputStream(fBdd);
            accesBdd.loadFromXML(source);
        } catch (IOException e) {
            throw new IOException("Le fichier Properties.xml n'a pas été trouvé.");
        }


        System.out.println(accesBdd.getProperty("bdd"));

        String url = "jdbc:mysql://" + accesBdd.getProperty("adresse") + ":" + accesBdd.getProperty("port") + "/" + accesBdd.getProperty("bdd");
        String login = accesBdd.getProperty("login");
        String pass = accesBdd.getProperty("pass");

        try {
            this.connexion = DriverManager.getConnection(url, login, pass);
        } catch (SQLException e) {
            throw new SQLException("Erreur SQL.");

        }

        return this.connexion;
    }
}
