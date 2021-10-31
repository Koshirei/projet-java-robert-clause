package dao;

import dao.mysql.MySQLDAOFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDAOFactory {
    private DAOFactory daoFactory;

    @Test
    public void testPersistenceMySQLOk() {
        this.daoFactory = DAOFactory.getDAOFactory(Persistence.MYSQL);
        Assert.assertEquals(MySQLDAOFactory.class, this.daoFactory.getClass());
    }
}
