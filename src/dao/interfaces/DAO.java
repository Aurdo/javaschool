package dao.interfaces;

import domain_objects.BaseDomainObject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aurdo on 06/02/14.
 */
public interface DAO<T extends BaseDomainObject> {
    public void add(T obj) throws SQLException;

    public void update(T obj) throws SQLException;

    public T getById(int id) throws SQLException;

    public List<T> getAll() throws SQLException;

    public void remove(int id) throws SQLException;

    public T getByName(String name) throws SQLException;

}
