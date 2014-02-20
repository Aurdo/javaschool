package dao.implementation.hibernate;

import dao.interfaces.DAOUser;
import domain_objects.User;

public class HibernateDAOUser extends HibernateDAO<User> implements DAOUser {

    protected Class getInnerClass() {
        return User.class;
    }
}
