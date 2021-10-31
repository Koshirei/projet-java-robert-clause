package dao;

import dao.mysql.*;
import org.junit.Assert;
import org.junit.Test;

public class TestMySQLDAOFactory {
    @Test
    public void testGetAbonnementDAOOk() {
        Assert.assertEquals(MySQLAbonnementDAO.class, MySQLDAOFactory.getDAOFactory(Persistence.MYSQL).getAbonnementDAO().getClass());
    }

    @Test
    public void testGetClientDAOOk() {
        Assert.assertEquals(MySQLClientDAO.class, MySQLDAOFactory.getDAOFactory(Persistence.MYSQL).getClientDAO().getClass());
    }

    @Test
    public void testGetPeriodiciteDAOOk() {
        Assert.assertEquals(MySQLPeriodiciteDAO.class, MySQLDAOFactory.getDAOFactory(Persistence.MYSQL).getPeriodiciteDAO().getClass());
    }

    @Test
    public void testGetRevueDAOOk() {
        Assert.assertEquals(MySQLRevueDAO.class, MySQLDAOFactory.getDAOFactory(Persistence.MYSQL).getRevueDAO().getClass());
    }

}
