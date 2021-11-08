package dao.mysql;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Abonnement;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMySQLAbonnement {
    MySQLAbonnementDAO mySQLAbonnementDAO;
    Abonnement abonnement;

    @Before
    public void init() throws Exception {
        mySQLAbonnementDAO = MySQLAbonnementDAO.getInstance();
        abonnement = new Abonnement(-2, 1, "abc999", new Date(0), new Date(10));
    }


    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(MySQLAbonnementDAO.class, mySQLAbonnementDAO.getClass());
    }

    @Test
    public void testCreerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLAbonnementDAO.creer(abonnement));
    }

    @Test
    public void testCreerPasOk() throws SQLException, IOException {
        try {
            abonnement = new Abonnement();
            Assert.assertFalse(this.mySQLAbonnementDAO.creer(abonnement));

            Assert.fail("Erreur");

        } catch (SQLIntegrityConstraintViolationException e) {
            Assert.assertEquals("Column 'referenceRevue' cannot be null", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() throws Exception {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(abonnement.getId(), mySQLAbonnementDAO.getById(abonnement.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() throws Exception {
        Assert.assertEquals(-1, mySQLAbonnementDAO.getById(-9).getId());
    }

    @Test
    public void testModifierOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLAbonnementDAO.modifier(abonnement));
    }

    @Test
    public void testModifierPasOk() throws SQLException, IOException {
        abonnement.setId(-9);
        Assert.assertFalse(this.mySQLAbonnementDAO.modifier(abonnement));
    }

    @Test
    public void testSupprimerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLAbonnementDAO.supprimer(abonnement));
    }

    @Test
    public void testSupprimerPasOk() throws SQLException, IOException {
        this.abonnement.setId(-1);
        Assert.assertFalse(this.mySQLAbonnementDAO.supprimer(abonnement));
    }
}
