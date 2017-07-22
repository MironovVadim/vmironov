package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Put Servlet.
 *  * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class DoPutServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = PostgresDBController.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        this.dbController.put(email, name);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
