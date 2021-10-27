package pojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClient {
    private Client client;

    @Before
    public void init() throws Exception {
        this.client = new Client (5, "Clause" , "Axel" , "45" , "les chardons", "57270","Uckange","France");
    }

    @Test
    public void testGetIdOk(){
        Assert.assertEquals(5,this.client.getId());
    }

    @Test
    public void testSetIdOk(){
        this.client.setId(10);
        Assert.assertEquals(10,this.client.getId());
    }

    @Test
    public void testGetNomOk(){
        Assert.assertEquals("Clause",this.client.getNom());
    }

    @Test
    public void testSetNomOk(){
        this.client.setNom("Robert");
        Assert.assertEquals("Robert",this.client.getNom());
    }

    @Test
    public void testGetPrenomOk(){
        Assert.assertEquals("Axel",this.client.getPrenom());
    }

    @Test
    public void testSetPrenomOk(){
        this.client.setPrenom("Nicolas");
        Assert.assertEquals("Nicolas", this.client.getPrenom());
    }

    @Test
    public void testGetNoRueOk(){
        Assert.assertEquals("45", this.client.getNoRue());
    }

    @Test
    public void testSetNoRueOk(){
        this.client.setNoRue("30");
        Assert.assertEquals("30", this.client.getNoRue());
    }

    @Test
    public void testGetVoieOk(){
        Assert.assertEquals("les chardons", this.client.getVoie());
    }

    @Test
    public void testSetVoieOk(){
        this.client.setVoie("voie romaine");
        Assert.assertEquals("voie romaine", this.client.getVoie());
    }

    @Test
    public void testGetCodePostalOk(){
        Assert.assertEquals("57270", this.client.getCodePostal());
    }

    @Test
    public void testSetCodePostalOk(){
        this.client.setCodePostal("40500");
        Assert.assertEquals("40500", this.client.getCodePostal());
    }

    @Test
    public void testGetVilleOk(){
        Assert.assertEquals("Uckange", this.client.getVille());
    }

    @Test
    public void testSetVilleOk(){
        this.client.setVille("Fort Fort Lointain");
        Assert.assertEquals("Fort Fort Lointain", this.client.getVille());
    }

    @Test
    public void testGetPaysOk(){
        Assert.assertEquals("France", this.client.getPays());
    }

    @Test
    public void testSetPaysOk(){
        this.client.setPays("Shrek");
        Assert.assertEquals("Shrek", this.client.getPays());
    }
}
