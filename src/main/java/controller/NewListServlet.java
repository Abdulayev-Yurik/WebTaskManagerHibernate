package controller;

import dao.TaskListDAO;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/newList"})
public class NewListServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
//        getSession factory
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        TaskListDAO taskListDAO = new TaskListDAO((SessionFactory) getServletContext().getAttribute("factory"));
        taskListDAO.createNewList(title);
        resp.sendRedirect("/home");
    }
}
