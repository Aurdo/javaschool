package util;

import org.hibernate.Session;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppServletContextListener implements ServletContextListener {
    public Session session = null;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        session.close();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        session = HibernateUtil.getSessionFactory().openSession();
    }
}