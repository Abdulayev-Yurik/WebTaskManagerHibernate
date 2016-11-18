package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/test"})
public class Test extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test----------------------------------------------------------------");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from ListTasks ");
//        Criteria criteria = session.createCriteria(ListTasks.class);
//        criteria.add(Restrictions.eq("id", 1));
//        ListTasks listTasks = (ListTasks) criteria.uniqueResult();

//        session.createQuery("insert into ListTasks()");
//        session.save(new ListTasks("test message"));
//        System.out.println(listTasks.getListName());
//        session.getTransaction().commit();
    }
}
