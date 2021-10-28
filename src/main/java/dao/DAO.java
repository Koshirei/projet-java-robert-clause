package dao;

public interface DAO<T> {
    public abstract T getById(int id);
    public abstract boolean supprimer(T objet);
    public abstract boolean creer(T objet);
    public abstract boolean modifier(T objet);
}
