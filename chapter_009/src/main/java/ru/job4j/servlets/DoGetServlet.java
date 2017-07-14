package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ПК on 08.07.2017.
 */
public class DoGetServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = PostgresDBController.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        List<String> users = this.dbController.get(id);
        StringBuilder usersTable = new StringBuilder("<table>");
        usersTable.append("<tr><th>Name</th><th>Login</th><th>Email</th><th>CreateDate</th></tr>");
        while (users.size() > 0) {
            usersTable.append("<tr>");
            usersTable.append("<td>" + users.remove(0) + "</td>");
            usersTable.append("<td>" + users.remove(0) + "</td>");
            usersTable.append("<td>" + users.remove(0) + "</td>");
            usersTable.append("<td>" + users.remove(0) + "</td>");
            usersTable.append("</tr>");
        }
        usersTable.append("</table");
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href=\"delServ\">delServ</a>\n" +
                "<br/>" +
                "<a href=\"postServ\">postServ</a>\n" +
                "<br/>" +
                "<a href=\"putServ\">putServ</a>\n" +
                "<br/>" +
                "<p>Get user</p>" +
                "<form action='" + req.getContextPath() + "/getServ' method='get'>" +
                "Id : <input type='text' name='id' />" +
                "<input type='submit'>" +
                "</form>" +
                "<br/>" +
                usersTable +
                "</body>\n" +
                "</html>");
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
        pw.append(sb.toString());
    }
}
