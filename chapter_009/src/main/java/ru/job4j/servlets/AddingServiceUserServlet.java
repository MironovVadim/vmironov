package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Adding new Service User Class.
 */
public class AddingServiceUserServlet extends HttpServlet {
    /**
     * DB Controller.
     */
    private ServiceDBController controller = PostgresServiceDBController.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        this.controller.addNewUser(login, password, role);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
