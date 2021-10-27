package pojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPeriodicite {
    private Periodicite periodicite;

    @Before
    public void init() throws Exception {
        this.periodicite = new Periodicite(5,"hello world");
    }

    @Test
    public void testGetIdOk(){
        Assert.assertEquals(5, this.periodicite.getId());
    }

    @Test
    public void testSetIdOk(){
        this.periodicite.setId(10);
        Assert.assertEquals(10 , this.periodicite.getId());
    }

    @Test
    public void testGetLibelleOk(){
        Assert.assertEquals("hello world" , this.periodicite.getLibelle());
    }

    @Test
    public void testSetLibelleOk(){
        this.periodicite.setLibelle("bonjour monde");
        Assert.assertEquals("bonjour monde", this.periodicite.getLibelle());
    }

    @Test
    public void testSetLibelleNormalisationOk(){
        this.periodicite.setLibelle("    bonjour monde    ");
        Assert.assertEquals("bonjour monde",this.periodicite.getLibelle());
    }
}
