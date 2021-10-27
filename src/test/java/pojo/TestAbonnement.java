package pojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class TestAbonnement {
    private Abonnement abonnement;

    @Before
    public void init() {
        this.abonnement = new Abonnement(0, "ABC001", new Date(0), new Date(10));
    }

    @Test
    public void testGetNumeroClientOk() {
        Assert.assertEquals(0, this.abonnement.getNumeroClient());
    }

    @Test
    public void testSetNumeroClientOk() {
        this.abonnement.setNumeroClient(1);
        Assert.assertEquals(1, this.abonnement.getNumeroClient());
    }

    @Test
    public void testGetReferenceRevueOk() {
        Assert.assertEquals("ABC001", this.abonnement.getReferenceRevue());
    }

    @Test
    public void testSetReferenceRevueOk() {
        this.abonnement.setReferenceRevue("XYZ999");
        Assert.assertEquals("XYZ999", this.abonnement.getReferenceRevue());
    }

    @Test
    public void testSetReferenceRevueNormalisationOk() {
        this.abonnement.setReferenceRevue("  xYz 999");
        Assert.assertEquals("XYZ999", this.abonnement.getReferenceRevue());
    }

    @Test
    public void testGetDateDebut() {
        Assert.assertEquals(new Date(0), this.abonnement.getDateDebut());
    }

    @Test
    public void testSetDateDebut() {
        this.abonnement.setDateDebut(new Date(1));

        Assert.assertEquals(new Date(1), this.abonnement.getDateDebut());
    }

    @Test
    public void testGetDateFin() {
        Assert.assertEquals(new Date(10), this.abonnement.getDateFin());
    }

    @Test
    public void testSetDateFin() {
        this.abonnement.setDateFin(new Date(11));

        Assert.assertEquals(new Date(11), this.abonnement.getDateFin());
    }
}
