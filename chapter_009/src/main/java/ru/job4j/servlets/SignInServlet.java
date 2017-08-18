package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * SignIn Servlet.
 */
public class SignInServlet extends HttpServlet {
    /**
     * DB Controller.
     */
    private Service controller = PostgresService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int userId = controller.checkServiceUser(login, password);
        if (userId == 0) {
            req.setAttribute("error", "Invalid login or password");
            this.doGet(req, resp);
        } else {
            String role = controller.getServiceRole(userId);
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
                session.setAttribute("role", role);
            }
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        }
    }
}