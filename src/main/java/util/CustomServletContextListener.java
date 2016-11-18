package util;

import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by employee on 11/17/16.
 */
@WebListener
public class CustomServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Innit context");
        ServletContext sc = servletContextEvent.getServletContext();
            SessionFactory session = HibernateUtil.getSessionFactory();
            sc.setAttribute("factory", session);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
