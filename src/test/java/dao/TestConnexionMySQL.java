package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestConnexionMySQL {
    private ConnexionMySQL connexion;

    @Before
    public void init() {
        this.connexion = ConnexionMySQL.getInstance();
    }

    @Test
    public void testCreeConnexionOk() {
        try {
            this.connexion.creeConnexion();

        } catch (IOException e) {
            Assert.assertEquals("Le fichier Properties.xml n'a pas été trouvé.", e.getMessage());

        } catch (SQLException e) {
            Assert.fail(e.getMessage());

        }
    }
}
