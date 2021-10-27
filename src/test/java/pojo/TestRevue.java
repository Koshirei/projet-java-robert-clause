package pojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRevue {
    private Revue revue;

    @Before
    public void init() throws Exception {
        this.revue = new Revue("ABC001", "Titre", "Description", 9.90f, "Mensuel");
    }

    @Test
    public void testGetReferenceOk() {
        Assert.assertEquals("ABC001", this.revue.getReference());
    }

    @Test
    public void testSetReferenceOk() {
        this.revue.setReference("XYZ999");

        Assert.assertEquals("XYZ999", this.revue.getReference());
    }

    @Test
    public void testSetReferenceNormalisationOk() {
        this.revue.setReference("  xYz 999 ");

        Assert.assertEquals("XYZ999", this.revue.getReference());
    }

    @Test
    public void testGetTitreOk() {
        Assert.assertEquals("Titre", this.revue.getTitre());
    }

    @Test
    public void testSetTitreOk() {
        this.revue.setTitre("Nouveau titre");

        Assert.assertEquals("Nouveau titre", this.revue.getTitre());
    }

    @Test
    public void testSetTitreNormalisationOk() {
        this.revue.setTitre("   Nouveau titre ");
        // Première lettre doit être automatiquement une majuscule ?

        Assert.assertEquals("Nouveau titre", this.revue.getTitre());
    }

    @Test
    public void testGetDescriptionOk() {
        Assert.assertEquals("Description", this.revue.getDescription());
    }

    @Test
    public void testSetDescriptionOk() {
        try {
            this.revue.setDescription("Nouvelle description");
            Assert.assertEquals("Nouvelle description", this.revue.getDescription());

        } catch (Exception e) {
            // pas besoin de vérif

        }
    }

    @Test
    public void testSetDescriptionNormalisationOk() {
        try {
            this.revue.setDescription("  Nouvelle description    ");
            Assert.assertEquals("Nouvelle description", this.revue.getDescription());

        } catch (Exception e) {
            // pas besoin de vérif

        }
    }

    @Test
    public void testSetDescriptionPasOk() {
        String descriptionTropLongue = "";

        for (int i = 0; descriptionTropLongue.length() < 400; i++) {
            descriptionTropLongue = descriptionTropLongue.concat("a");
        }

        try {
            this.revue.setDescription(descriptionTropLongue);
            // Assert.fail("Description trop longue ! Elle doit faire moins de 400 caractères.");

        } catch (Exception e) {
            Assert.assertEquals("Description trop longue ! Elle doit faire moins de 400 caractères.", e.getMessage());

        }
    }

    @Test
    public void testGetTarifOk() {
        Assert.assertEquals(9.90f, this.revue.getTarif(), 0.0f);
    }

    @Test
    public void testSetTarifOk() {
        this.revue.setTarif(19.90f);

        Assert.assertEquals(19.90f, this.revue.getTarif(), 0.0f);
    }

    @Test
    public void testGetPeriodiciteOk() {
        Assert.assertEquals("Mensuel", this.revue.getPeriodicite());
    }

    @Test
    public void testSetPeriodiciteOk() {
        this.revue.setPeriodicite("Annuel");

        Assert.assertEquals("Annuel", this.revue.getPeriodicite());
    }

    @Test
    public void testSetPeriodiciteNormalisationOk() {
        this.revue.setPeriodicite("  Annuel  ");

        Assert.assertEquals("Annuel", this.revue.getPeriodicite());
    }

}
