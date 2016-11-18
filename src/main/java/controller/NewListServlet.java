package controller;

import dao.ListDAO;
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
 * Created by employee on 11/17/16.
 */
@WebServlet({"/newList"})
public class NewListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        ListDAO listDAO = new ListDAO((SessionFactory) getServletContext().getAttribute("factory"));
        listDAO.createNewList(title);
        resp.sendRedirect("/home");
    }
}
