package ru.job4j.carstorage.servlets;

import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet registers new User.
 */
public class UserManageServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text");
        PrintWriter writer = resp.getWriter();
        writer.print("wrongLogin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (service.isUserLoginExist(login)) {
            doGet(req, resp);
        } else {
            int userId = service.addNewUser(nickname, login, password);
            req.getSession().setAttribute("id", userId);
            resp.sendRedirect(String.format("%s/carstorage/login.html", req.getContextPath()));
        }
    }
}
