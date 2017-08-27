package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlets returns users as attribute.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class GetAllUsersServlet extends HttpServlet {
    /**
     * User DB Controller.
     */
    private DBController usersController = PostgresDBController.newInstance();
    /**
     * Service user DB Controller.
     */
    private Service serviceUsersController = PostgresService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", usersController.get());
        req.setAttribute("serviceUsers", serviceUsersController.getServiceUsers());
        req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
    }
}
