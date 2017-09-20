package ru.job4j.carstorage.servlets;

import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckUserServlet extends HttpServlet {

    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text");
        PrintWriter writer = resp.getWriter();
        writer.print("incorrectInfo");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int id = service.checkUser(login, password);
        if (id > 0) {
            req.getSession().setAttribute("id", id);
            resp.sendRedirect(String.format("%s/carstorage/login.html", req.getContextPath()));
        } else {
            this.doGet(req, resp);
        }
    }
}
