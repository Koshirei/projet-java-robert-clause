package dao.listememoire;

import dao.mysql.MySQLClientDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Abonnement;

import java.sql.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestListeMemoireAbonnementDAO {
    ListeMemoireAbonnementDAO listeMemoireAbonnement;
    Abonnement abonnement;

    @Before
    public void init() {
        listeMemoireAbonnement = ListeMemoireAbonnementDAO.getInstance();
        abonnement = new Abonnement(-2, -2, "ABC", new Date(0), new Date(10));
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(ListeMemoireAbonnementDAO.class, listeMemoireAbonnement.getClass());
    }

    @Test
    public void testCreerOk() throws Exception {
        Assert.assertTrue(this.listeMemoireAbonnement.creer(abonnement));
    }

    @Test
    public void testCreerPasOk() {
        try {
            abonnement = new Abonnement();
            this.listeMemoireAbonnement.creer(abonnement);

            Assert.fail("Erreur, ne doit pas fonctionner");

        } catch (Exception e) {
            Assert.assertEquals("Une des valeurs n'est pas définie", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(abonnement.getId(), listeMemoireAbonnement.getById(abonnement.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() {
        try {
            listeMemoireAbonnement.getById(-9).getId();

            Assert.fail("Ne doit pas fonctionner.");


        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Aucun objet ne possède cet identifiant", e.getMessage());

        }
    }

    @Test
    public void testModifierOk() {
        Assert.assertTrue(this.listeMemoireAbonnement.modifier(abonnement));
    }

    @Test
    public void testModifierPasOk() {
        try {
            abonnement.setId(-9);
            Assert.assertFalse(this.listeMemoireAbonnement.modifier(abonnement));
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }

    }

    @Test
    public void testSupprimerOk() {
        Assert.assertTrue(this.listeMemoireAbonnement.supprimer(abonnement));
    }

    @Test
    public void testSupprimerPasOk() {


        try {
            this.abonnement.setId(-9);
            this.listeMemoireAbonnement.supprimer(abonnement);

        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }
    }
}
