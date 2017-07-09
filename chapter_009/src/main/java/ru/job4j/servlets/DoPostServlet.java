package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ПК on 08.07.2017.
 */
public class DoPostServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = new PostgresDBController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href=\"delServ\">delServ</a>\n" +
                "<a href=\"getServ\">getServ</a>\n" +
                "<a href=\"putServ\">putServ</a>\n" +
                "<br/>" +
                "<p>Add user</p>" +
                "<form action='" + req.getContextPath() + "/postServ' method='post'>" +
                "Name : <input type='text' name='name' />" +
                "Login : <input type='text' name='login' />" +
                "Email : <input type='text' name='email' />" +
                "<input type='submit'>" +
                "</form>" +
                "<br/>" +
                "</body>\n" +
                "</html>");
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
        pw.append(sb.toString());
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        this.dbController.post(name, login, email);
    }
}
