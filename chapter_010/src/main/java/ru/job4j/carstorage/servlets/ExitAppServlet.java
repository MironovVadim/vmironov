package ru.job4j.carstorage.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for exit from app.
 */
@WebServlet(name = "exit", urlPatterns = "/carstorage/exit")
public class ExitAppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(String.format("%s/carstorage/login.html", req.getContextPath()));
    }
}
