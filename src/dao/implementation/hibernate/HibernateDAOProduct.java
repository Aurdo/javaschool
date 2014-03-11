package dao.implementation.hibernate;

import dao.interfaces.DAOProduct;
import domain_objects.Category;
import domain_objects.Product;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;

public class HibernateDAOProduct extends HibernateDAO<Product> implements DAOProduct {

    protected Class getInnerClass() {
        return Product.class;
    }

    protected void CreateNewProduct(Product product, Category category)throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Data error", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
