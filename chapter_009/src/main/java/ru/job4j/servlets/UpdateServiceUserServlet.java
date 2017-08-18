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
    private Service controller = PostgresService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String currentUserLogin = (String) session.getAttribute("login");
        String newLogin = req.getParameter("newLogin");
        String newPassword = req.getParameter("password");

        if (("User").equals(session.getAttribute("role"))) {
            if (!newLogin.isEmpty()) {
                this.controller.updateServiceUserLogin(currentUserLogin, newLogin);
                session.setAttribute("login", newLogin);
                currentUserLogin = newLogin;
            }
            if (!newPassword.isEmpty()) {
                this.controller.updateServiceUserPassword(currentUserLogin, newPassword);
            }
        }

        if (("Administrator").equals(session.getAttribute("role"))) {
            String loginForChange = req.getParameter("login");
            String newRole = req.getParameter("role");
            if (!loginForChange.isEmpty() && !newLogin.isEmpty()) {
                this.controller.updateServiceUserLogin(loginForChange, newLogin);
                if (loginForChange.equals(currentUserLogin)) {
                    session.setAttribute("login", newLogin);
                }
                loginForChange = newLogin;
            }
            if (!loginForChange.isEmpty() && !newPassword.isEmpty()) {
                this.controller.updateServiceUserPassword(loginForChange, newPassword);
            }
            if (!loginForChange.isEmpty() && newRole != null && !newRole.isEmpty()) {
                this.controller.updateServiceUserRole(loginForChange, newRole);
                if (loginForChange.equals(currentUserLogin)) {
                    session.setAttribute("role", newRole);
                }
            }
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
