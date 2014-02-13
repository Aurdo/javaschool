package dao;

import dao.implementation.hibernate.HibernateDAOCategory;

public class Factory {

    private static HibernateDAOCategory DAOCategory = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public HibernateDAOCategory CategoryDAO() {
        if (DAOCategory == null) {
            DAOCategory = new HibernateDAOCategory();
        }
        return DAOCategory;
    }

}
