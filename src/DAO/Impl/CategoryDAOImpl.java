package DAO.Impl;

import DAO.Abstract.CategoryDAO;
import logic.Category;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

	public void add(Category cat) {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.save(cat);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }

	  public void update(Category cat) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.update(cat);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }

	  public Category getById(int id) throws SQLException {
		    Session session = null;
            Category cat = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
                cat = (Category) session.load(Category.class, id);
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return cat;
	  }

	  public List<Category> getAll() throws SQLException {
		    Session session = null;
		    List<Category> cats = new ArrayList<Category>();
		    try {
                session = HibernateUtil.getSessionFactory().openSession();
                Class tmmp = Category.class;
		    	cats = session.createCriteria(Category.class).list();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return cats;
	  }

	  public void remove(int id) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.delete(this.getById(id));
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка данных", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }


}
