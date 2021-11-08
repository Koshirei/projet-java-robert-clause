package dao;

import dao.mysql.MySQLDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getDAOFactory(Persistence persistance) {
        DAOFactory daof = null;

        switch (persistance) {
            case MYSQL:
                daof = new MySQLDAOFactory();
                break;

            default:
                new Exception("Cette persistence n'existe pas");
                break;
        }

        return daof;
    }

    public abstract AbonnementDAO getAbonnementDAO() throws Exception;
    public abstract ClientDAO getClientDAO();
    public abstract PeriodiciteDAO getPeriodiciteDAO();
    public abstract RevueDAO getRevueDAO();
}