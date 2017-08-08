package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class for updating service users.
 */
public class UpdateServiceUserServlet extends HttpServlet {
    /**
     * DB Controller.
     */
    private ServiceDBController controller = PostgresServiceDBController.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String currentUserLogin = (String) session.getAttribute("login");
        String newLogin = req.getParameter("newLogin");
        String newPassword = req.getParameter("password");

        if (session.getAttribute("role") == "User") {
            if (newLogin != null) {
                this.controller.updateServiceUserLogin(currentUserLogin, newLogin);
                session.setAttribute("login", newLogin);
                currentUserLogin = newLogin;
            }
            if (newPassword != null) {
                this.controller.updateServiceUserPassword(currentUserLogin, newPassword);
            }
        }

        if (session.getAttribute("role") == "Administrator") {
            String loginForChange = req.getParameter("login");
            String newRole = req.getParameter("role");
            if (newLogin != null) {
                if (currentUserLogin.equals(loginForChange)) {
                    session.setAttribute("login", newLogin);
                }
                this.controller.updateServiceUserLogin(currentUserLogin, newLogin);
                currentUserLogin = newLogin;
            }
            if (newPassword != null) {
                this.controller.updateServiceUserPassword(currentUserLogin, newPassword);
            }
            if (newRole != null) {
                this.controller.updateServiceUserRole(currentUserLogin, newRole);
                if (currentUserLogin.equals(session.getAttribute("role"))) {
                    session.setAttribute("role", newRole);
                }
            }
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
