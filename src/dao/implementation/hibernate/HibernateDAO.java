package dao.implementation.hibernate;

import domain_objects.BaseDomainObject;
import org.hibernate.Session;
import util.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


abstract class HibernateDAO<T extends BaseDomainObject> implements dao.interfaces.DAO<T> {

    //private Class<T> innerClass;

    /*protected HibernateDAO() {
        this.innerClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }*/
    abstract protected Class getInnerClass();

    public void add(T t) throws SQLException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            /*if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
    }

    public void update(T t) throws SQLException {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            /*if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
    }

    public T getById(int id) throws SQLException {
        //Session session = null;
        T t = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            t = (T) session.load(this.getInnerClass(), id);
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            /*if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
        return t;
    }

    public List<T> getAll() throws SQLException {
        //Session session = null;
        List<T> t = new ArrayList<T>();
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            t = session.createCriteria(this.getInnerClass()).list();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            /*if (session != null && session.isOpen()) {
                session.close();
            }*/
        }
        return t;
    }

    public void remove(int id) throws SQLException {
        //Session session = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            /*f (session != null && session.isOpen()) {
                session.close();
            }*/
        }
    }

}
