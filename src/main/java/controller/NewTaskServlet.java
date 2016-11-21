package controller;

import dao.TaskListDAO;
import dao.TaskDAO;
import model.TaskList;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by yurik on 14.11.16.
 */
@WebServlet({"/newTask"})
public class NewTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
            if (title == null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/add_task.jsp");
                List<TaskList> listTasks = new TaskListDAO((SessionFactory) getServletContext().getAttribute("factory"))
                        .getAllListTasks();
                req.setAttribute("lists", listTasks);
                dispatcher.forward(req, resp);
            }else {
                TaskDAO dao = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
                dao.addNewTask(title, req.getParameter("details"),
                        parseInt(req.getParameter("listId")), req.getParameter("dueDate"));
                resp.sendRedirect("/home");
            }
    }


}
