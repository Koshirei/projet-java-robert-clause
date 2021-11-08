package dao.listememoire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pojo.Client;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestListeMemoireClientDAO {

    ListeMemoireClientDAO listeMemoireClient;
    Client client;

    @Before
    public void init() {
        listeMemoireClient = ListeMemoireClientDAO.getInstance();
        client = new Client(-2, "ABC", "DEF", "123", "GHI", "456", "JKL", "MNO");
    }

    @Test
    public void testGetInstanceOk() {
        Assert.assertEquals(ListeMemoireClientDAO.class, listeMemoireClient.getClass());
    }

    @Test
    public void testCreerOk() throws Exception {
        Assert.assertTrue(this.listeMemoireClient.creer(client));
    }

    @Test
    public void testCreerPasOk() {
        try {
            client = new Client();
            this.listeMemoireClient.creer(client);

            Assert.fail("Erreur, ne doit pas fonctionner");

        } catch (Exception e) {
            Assert.assertEquals("Une des valeurs n'est pas définie", e.getMessage());
        }

    }

    @Test
    public void testGetByIdOk() {
        // il doit y avoir un element avec l'id 1 sinon ne amrche pas
        Assert.assertEquals(client.getId(), listeMemoireClient.getById(client.getId()).getId());
    }

    @Test
    public void testGetByIdPasOk() {
        try {
            listeMemoireClient.getById(-9).getId();

            Assert.fail("Ne doit pas fonctionner.");


        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Aucun objet ne possède cet identifiant", e.getMessage());

        }
    }

    @Test
    public void testModifierOk() {
        Assert.assertTrue(this.listeMemoireClient.modifier(client));
    }

    @Test
    public void testModifierPasOk() {
        try {
            client.setId(-9);
            Assert.assertFalse(this.listeMemoireClient.modifier(client));
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }

    }

    @Test
    public void testSupprimerOk() {
        Assert.assertTrue(this.listeMemoireClient.supprimer(client));
    }

    @Test
    public void testSupprimerPasOk() {


        try {
            this.client.setId(-9);
            this.listeMemoireClient.supprimer(client);

        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Tentative de modification d'un objet inexistant", e.getMessage());

        }
    }
}
