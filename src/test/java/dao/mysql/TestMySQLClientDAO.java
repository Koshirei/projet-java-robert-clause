package dao.mysql;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Abonnement;
import pojo.Client;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMySQLClientDAO {
    MySQLClientDAO mySQLClientDAO;
    Client client;

    @Before
    public void init() throws SQLException, IOException {
        mySQLClientDAO = MySQLClientDAO.getInstance();
        client = new Client(-2, "a", "a", "a", "a", "a", "a" ,"a");
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(MySQLClientDAO.class, mySQLClientDAO.getClass());
    }

    @Test
    public void testCreerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLClientDAO.creer(client));
    }

    @Test
    public void testCreerPasOk() throws SQLException, IOException {
        try {
            client = new Client();
            Assert.assertFalse(this.mySQLClientDAO.creer(client));

            Assert.fail("Erreur");

        } catch (SQLIntegrityConstraintViolationException e) {
            Assert.assertEquals("Column 'nom' cannot be null", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() throws SQLException, IOException {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(client.getId(), mySQLClientDAO.getById(client.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() throws SQLException, IOException {
        Assert.assertEquals(-1, mySQLClientDAO.getById(-9).getId());
    }

    @Test
    public void testModifierOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLClientDAO.modifier(client));
    }

    @Test
    public void testModifierPasOk() throws SQLException, IOException {
        client.setId(-9);
        Assert.assertFalse(this.mySQLClientDAO.modifier(client));
    }

    @Test
    public void testSupprimerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLClientDAO.supprimer(client));
    }

    @Test
    public void testSupprimerPasOk() throws SQLException, IOException {
        this.client.setId(-1);
        Assert.assertFalse(this.mySQLClientDAO.supprimer(client));
    }
}
