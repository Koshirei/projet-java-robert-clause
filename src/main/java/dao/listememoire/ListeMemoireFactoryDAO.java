package dao.listememoire;

import dao.*;

public class ListeMemoireFactoryDAO extends DAOFactory {
    @Override
    public AbonnementDAO getAbonnementDAO() throws Exception {
        return ListeMemoireAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO() {
        return ListeMemoireClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() {
        return ListeMemoirePeriodiciteDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO() {
        return null;
    }
}
