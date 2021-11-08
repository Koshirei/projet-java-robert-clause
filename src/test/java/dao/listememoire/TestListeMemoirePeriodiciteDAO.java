package dao.listememoire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Periodicite;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestListeMemoirePeriodiciteDAO {

    ListeMemoirePeriodiciteDAO listeMemoirePeriodicite;
    Periodicite periodicite;

    @Before
    public void init() {
        listeMemoirePeriodicite = ListeMemoirePeriodiciteDAO.getInstance();
        periodicite = new Periodicite(-2, "PeriodeTest");
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(ListeMemoirePeriodiciteDAO.class, listeMemoirePeriodicite.getClass());
    }

    @Test
    public void testCreerOk() throws Exception {
        Assert.assertTrue(this.listeMemoirePeriodicite.creer(periodicite));
    }

    @Test
    public void testCreerPasOk() {
        try {
            periodicite = new Periodicite();
            this.listeMemoirePeriodicite.creer(periodicite);

            Assert.fail("Erreur, ne doit pas fonctionner");

        } catch (Exception e) {
            Assert.assertEquals("Une des valeurs n'est pas définie", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(periodicite.getId(), listeMemoirePeriodicite.getById(periodicite.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() {
        try {
            listeMemoirePeriodicite.getById(-9).getId();

            Assert.fail("Ne doit pas fonctionner.");


        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Aucun objet ne possède cet identifiant", e.getMessage());

        }
    }

    @Test
    public void testModifierOk() {
        Assert.assertTrue(this.listeMemoirePeriodicite.modifier(periodicite));
    }

    @Test
    public void testModifierPasOk() {
        try {
            periodicite.setId(-9);
            Assert.assertFalse(this.listeMemoirePeriodicite.modifier(periodicite));
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }

    }

    @Test
    public void testSupprimerOk() {
        Assert.assertTrue(this.listeMemoirePeriodicite.supprimer(periodicite));
    }

    @Test
    public void testSupprimerPasOk() {


        try {
            this.periodicite.setId(-9);
            this.listeMemoirePeriodicite.supprimer(periodicite);

        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de suppression d'un objet inexistant", e.getMessage());

        }
    }


}
