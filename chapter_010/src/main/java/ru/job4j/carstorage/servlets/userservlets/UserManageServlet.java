package ru.job4j.carstorage.servlets.userservlets;

import ru.job4j.carstorage.entities.User;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet registers new User.
 */
@WebServlet(name = "userAdding", urlPatterns = "/carstorage/createUser")
public class UserManageServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (service.isUserLoginExist(login)) {
            resp.sendError(400, "This login already exist!");
        } else {
            User user = new User(nickname, login, password, new Date());
            service.addNewUser(user);
            req.getSession().setAttribute("id", user.getId());
        }
    }
}
