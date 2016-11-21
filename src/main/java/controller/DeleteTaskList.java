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
 * Created by employee on 11/21/16.
 */
@WebServlet({"/deleteList"})
public class DeleteTaskList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String listId = req.getParameter("listId");
        TaskListDAO taskListDAO = new TaskListDAO((SessionFactory) getServletContext().getAttribute("factory"));
        taskListDAO.deleteTaskList(listId);
        resp.sendRedirect("/taskLists");
    }
}
