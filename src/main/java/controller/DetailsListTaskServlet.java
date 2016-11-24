package controller;

import dao.TaskListDAO;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/21/16.
 */
@WebServlet({"/taskLists"})
public class DetailsListTaskServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskListDAO listDAO = new TaskListDAO((SessionFactory) getServletContext().getAttribute("factory"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/task_list.jsp");
        req.setAttribute("taskLists", listDAO.getAllListTasks());
        dispatcher.forward(req, resp);
    }
}
