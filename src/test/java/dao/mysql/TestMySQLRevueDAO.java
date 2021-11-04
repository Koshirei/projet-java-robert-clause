package dao.mysql;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Periodicite;
import pojo.Revue;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMySQLRevueDAO {
    MySQLRevueDAO mySQLRevueDAO;
    Revue revue;

    @Before
    public void init() throws Exception {
        mySQLRevueDAO = MySQLRevueDAO.getInstance();
        revue = new Revue(-2, "a", "a", "a", 0.0f, "a");
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(MySQLRevueDAO.class, mySQLRevueDAO.getClass());
    }

    @Test
    public void testCreerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLRevueDAO.creer(revue));
    }

    @Test
    public void testCreerPasOk() throws Exception {
        try {
            revue = new Revue();
            Assert.assertFalse(this.mySQLRevueDAO.creer(revue));

            Assert.fail("Erreur");

        } catch (SQLIntegrityConstraintViolationException e) {
            Assert.assertEquals("Column 'reference' cannot be null", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() throws Exception {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(revue.getId(), mySQLRevueDAO.getById(revue.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() throws Exception {
        Assert.assertEquals(-1, mySQLRevueDAO.getById(-9).getId());
    }

    @Test
    public void testModifierOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLRevueDAO.modifier(revue));
    }

    @Test
    public void testModifierPasOk() throws SQLException, IOException {
        revue.setId(-9);
        Assert.assertFalse(this.mySQLRevueDAO.modifier(revue));
    }

    @Test
    public void testSupprimerOk() throws SQLException, IOException {
        Assert.assertTrue(this.mySQLRevueDAO.supprimer(revue));
    }

    @Test
    public void testSupprimerPasOk() throws SQLException, IOException {
        this.revue.setId(-1);
        Assert.assertFalse(this.mySQLRevueDAO.supprimer(revue));
    }

}
