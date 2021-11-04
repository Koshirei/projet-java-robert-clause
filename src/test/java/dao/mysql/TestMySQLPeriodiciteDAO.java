package dao.mysql;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Client;
import pojo.Periodicite;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMySQLPeriodiciteDAO {
    MySQLPeriodiciteDAO mySQLPeriodiciteDAO;
    Periodicite periodicite;

    @Before
    public void init() throws SQLException, IOException {
        mySQLPeriodiciteDAO = MySQLPeriodiciteDAO.getInstance();
        periodicite = new Periodicite(-2, "a");
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(MySQLPeriodiciteDAO.class, mySQLPeriodiciteDAO.getClass());
    }

    @Test
    public void testCreerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLPeriodiciteDAO.creer(periodicite));
    }

    @Test
    public void testCreerPasOk() throws SQLException, IOException {
        try {
            periodicite = new Periodicite();
            Assert.assertFalse(this.mySQLPeriodiciteDAO.creer(periodicite));

            Assert.fail("Erreur");

        } catch (SQLIntegrityConstraintViolationException e) {
            Assert.assertEquals("Column 'libelle' cannot be null", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() throws SQLException, IOException {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(periodicite.getId(), mySQLPeriodiciteDAO.getById(periodicite.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() throws SQLException, IOException {
        Assert.assertEquals(-1, mySQLPeriodiciteDAO.getById(-9).getId());
    }

    @Test
    public void testModifierOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLPeriodiciteDAO.modifier(periodicite));
    }

    @Test
    public void testModifierPasOk() throws SQLException, IOException {
        periodicite.setId(-9);
        Assert.assertFalse(this.mySQLPeriodiciteDAO.modifier(periodicite));
    }

    @Test
    public void testSupprimerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLPeriodiciteDAO.supprimer(periodicite));
    }

    @Test
    public void testSupprimerPasOk() throws SQLException, IOException {
        this.periodicite.setId(-1);
        Assert.assertFalse(this.mySQLPeriodiciteDAO.supprimer(periodicite));
    }
}
