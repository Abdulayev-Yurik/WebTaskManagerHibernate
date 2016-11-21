package controller;

import dao.ListDAO;
import dao.TaskDAO;
import model.Task;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/home"})
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String listId = req.getParameter("listId");
        TaskDAO taskDAO = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
        ListDAO listDAO = new ListDAO((SessionFactory) getServletContext().getAttribute("factory"));
        List<Task> taskActiveList = new ArrayList();
        List<Task> taskDoneList = new ArrayList();

        List<Task> tasks = listId == null ? taskDAO.getAllTasks() : taskDAO.getTasksFromList(listId);
        for (Task task : tasks) {
            if (task.isActive()) {
                taskActiveList.add(task);
            } else {
                taskDoneList.add(task);
            }
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        req.setAttribute("taskActiveList", taskActiveList);
        req.setAttribute("taskDoneList", taskDoneList);
        req.setAttribute("listTasks", listDAO.getAllListTasks());
        req.setAttribute("listId", listId);
        dispatcher.forward(req, resp);
    }
}
