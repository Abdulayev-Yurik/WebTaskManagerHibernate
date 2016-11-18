package controller;

import dao.TaskDAO;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/messages"})
public class NewMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        String message = req.getParameter("n_message");

            TaskDAO taskDAO = new TaskDAO((SessionFactory) getServletContext().getAttribute("factory"));
            taskDAO.addNewMessage(taskId, message);
            resp.sendRedirect("/details?task=" + taskId);
    }
}
