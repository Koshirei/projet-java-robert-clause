package pojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class TestAbonnement {
    private Abonnement abonnement;
    private Abonnement abonnementnull;

    @Before
    public void init() throws Exception {
        this.abonnement = new Abonnement(0, 0, "ABC001", new Date(0), new Date(10));
        this.abonnementnull = new Abonnement(0, 0, "", null, null);
    }

    @Test
    public void testGetIdOk() {
        Assert.assertEquals(0, this.abonnement.getId());
    }

    @Test
    public void testSetIdOk() {
        this.abonnement.setId(1);

        Assert.assertEquals(1, this.abonnement.getId());
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
    public void testSetReferenceRevueOk() throws Exception {
        this.abonnement.setReferenceRevue("XYZ999");
        Assert.assertEquals("XYZ999", this.abonnement.getReferenceRevue());
    }

    @Test
    public void testSetReferenceRevueNormalisationOk() throws Exception {
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
    @Test
    public void testAbonnementEstNull() throws Exception {
        Assert.assertEquals(new Abonnement(0, 0, "", null, null), abonnementnull);
    }

    @Test
    public void testAbonnementEstNullPasOk(){ try{
        Assert.assertEquals(new Abonnement(0, 0, null, null, null), abonnementnull);Assert.fail("doit pas marcher");
    }
    catch(Exception e ){
        Assert.assertEquals(e.getMessage(),"Reference revue null");
    }
    }

    @Test
    public void testIDestNull(){
        Assert.assertEquals(0, abonnementnull.getId());
    }
    @Test
    public void testNumeroClientEstNull(){
        Assert.assertEquals(0, abonnementnull.getNumeroClient());
    }
    @Test
    public void testReferenceRevueEstNull(){
        Assert.assertEquals("", abonnementnull.getReferenceRevue());
    }
    @Test
    public void testDateDebutEstNull(){
        Assert.assertEquals(null, abonnementnull.getDateDebut());
    }
    @Test
    public void testDateFinEstNull(){
        Assert.assertEquals(null, abonnementnull.getDateFin());
    }

}
