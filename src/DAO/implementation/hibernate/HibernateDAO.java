package dao.implementation.hibernate;

import domain_objects.BaseDomainObject;
import org.hibernate.Session;
import util.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2/10/14.
 */
class HibernateDAO<T extends BaseDomainObject> implements dao.interfaces.DAO<T> {

    private Class<T> innerClass;

    protected HibernateDAO() {
        this.innerClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void add(T t) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(T t) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public T getById(int id) throws SQLException {
        Session session = null;
        T t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = (T) session.load(this.innerClass, id);
        } catch (Exception e) {
            throw new SQLException("Data error", e);
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Data error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }

    public List<T> getAll() throws SQLException {
        Session session = null;
        List<T> t = new ArrayList<T>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = session.createCriteria(this.innerClass).list();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }

    public void remove(int id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
