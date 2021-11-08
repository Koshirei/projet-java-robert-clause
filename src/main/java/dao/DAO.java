package dao;

import java.io.IOException;
import java.sql.SQLException;

public interface DAO<T> {
    public abstract T getById(int id) throws Exception;
    public abstract boolean supprimer(T objet) throws SQLException, IOException;
    public abstract boolean creer(T objet) throws SQLException, IOException, Exception;
    public abstract boolean modifier(T objet) throws SQLException, IOException;
}
