package dao.implementation.hibernate;

import dao.interfaces.DAOProduct;
import domain_objects.Product;

public class HibernateDAOProduct extends HibernateDAO<Product> implements DAOProduct {

    protected Class getInnerClass() {
        return Product.class;
    }

}
