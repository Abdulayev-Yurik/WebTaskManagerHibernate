package dao;

import model.ListTasks;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/17/16.
 */
public class ListDAO {

    private Session session;

    public ListDAO(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public List<ListTasks> getAllListTasks() {
        Criteria criteria = session.createCriteria(ListTasks.class);
        List<ListTasks> listTaskses = (List<ListTasks>) criteria.list();
        return listTaskses;
    }

    public void createNewList(String title) {
        session.beginTransaction();
        session.save(new ListTasks(title));
        session.getTransaction().commit();
        session.close();
    }
}
