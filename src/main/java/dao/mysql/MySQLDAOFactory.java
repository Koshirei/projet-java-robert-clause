package dao.mysql;

import dao.*;

public class MySQLDAOFactory extends DAOFactory {
    @Override
    public AbonnementDAO getAbonnementDAO() {
        return MySQLAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO() {
        return MySQLClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() {
        return MySQLPeriodiciteDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO() {
        return MySQLRevueDAO.getInstance();
    }
}