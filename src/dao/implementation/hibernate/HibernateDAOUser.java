package dao.implementation.hibernate;

import dao.interfaces.DAOUser;
import domain_objects.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.sql.SQLException;

public class HibernateDAOUser extends HibernateDAO<User> implements DAOUser {

    protected Class getInnerClass() {
        return User.class;
    }

    public User getByName(String name) throws SQLException {
        Session session = null;
        User Info;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Info = (User) session.createCriteria(User.class).add(Restrictions.eq("name", name)).list();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return Info;
    }
}
