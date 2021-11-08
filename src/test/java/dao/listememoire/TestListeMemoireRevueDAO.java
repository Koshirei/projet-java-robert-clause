package dao.listememoire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Revue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestListeMemoireRevueDAO {

    ListeMemoireRevueDAO listeMemoireRevue;
    Revue revue;

    @Before
    public void init() throws Exception {
        listeMemoireRevue = ListeMemoireRevueDAO.getInstance();
        revue = new Revue(-2, "Titi", "Toto", "Toto part en aventure", 15.2f,"hebdomadaire");
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(ListeMemoireRevueDAO.class, listeMemoireRevue.getClass());
    }

    @Test
    public void testCreerOk() throws Exception {
        Assert.assertTrue(this.listeMemoireRevue.creer(revue));
    }

    @Test
    public void testCreerPasOk() {
        try {
            revue = new Revue();
            this.listeMemoireRevue.creer(revue);

            Assert.fail("Erreur, ne doit pas fonctionner");

        } catch (Exception e) {
            Assert.assertEquals("Une des valeurs n'est pas définie", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() throws Exception {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(revue.getId(), listeMemoireRevue.getById(revue.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() throws Exception {
        try {
            listeMemoireRevue.getById(-9).getId();

            Assert.fail("Ne doit pas fonctionner.");


        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Aucun objet ne possède cet identifiant", e.getMessage());

        }
    }

    @Test
    public void testModifierOk() {
        Assert.assertTrue(this.listeMemoireRevue.modifier(revue));
    }

    @Test
    public void testModifierPasOk() {
        try {
            revue.setId(-9);
            Assert.assertFalse(this.listeMemoireRevue.modifier(revue));
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }

    }

    @Test
    public void testSupprimerOk() {
        Assert.assertTrue(this.listeMemoireRevue.supprimer(revue));
    }

    @Test
    public void testSupprimerPasOk() {


        try {
            this.revue.setId(-9);
            this.listeMemoireRevue.supprimer(revue);

        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }
    }

}
