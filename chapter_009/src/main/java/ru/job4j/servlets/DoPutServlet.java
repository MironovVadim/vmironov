package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ПК on 08.07.2017.
 */
public class DoPutServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = new PostgresDBController();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        this.dbController.put(email, name);
    }
}
