package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by employee on 11/17/16.
 */
public class MessageDAO {

    private Session session;

    public MessageDAO(SessionFactory sessionFactory) throws SQLException, ClassNotFoundException {
        this.session = sessionFactory.openSession();
    }
}
