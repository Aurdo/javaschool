package dao;

import dao.implementation.hibernate.HibernateDAOCategory;

public class Factory {

    private static HibernateDAOCategory DAO_CATEGORY = null;
    private static Factory INSTANCE = null;

    public static synchronized Factory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Factory();
        }
        return INSTANCE;
    }

    public HibernateDAOCategory DAOCategory() {
        if (DAO_CATEGORY == null) {
            DAO_CATEGORY = new HibernateDAOCategory();
        }
        return DAO_CATEGORY;
    }

}
