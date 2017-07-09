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
public class DoPutServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = new PostgresDBController();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                "<a href=\"postServ\">postServ</a>\n" +
                "<br/>" +
                "<p>Update user</p>" +
                "<form action='" + req.getContextPath() + "/putServ' method='put'>" +
                "Email : <input type='text' name='email' />" +
                "Name : <input type='text' name='name' />" +
                "<input type='submit'>" +
                "</form>" +
                "<br/>" +
                "</body>\n" +
                "</html>");
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
        pw.append(sb.toString());
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        this.dbController.put(email, name);
    }
}
