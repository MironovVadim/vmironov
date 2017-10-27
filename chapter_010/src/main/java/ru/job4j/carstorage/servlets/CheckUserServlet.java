package ru.job4j.carstorage.servlets;

import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet check existence of user.
 */
@WebServlet(name = "signIn", urlPatterns = "/carstorage/signIn")
public class CheckUserServlet extends HttpServlet {
    /**
     * Data base service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int id = service.checkUser(login, password);
        if (id > 0) {
            req.getSession().setAttribute("id", id);
        } else {
            resp.sendError(400, "Wrong login or password.");
        }
    }
}
