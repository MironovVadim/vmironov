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
public class DoDeleteServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = new PostgresDBController();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href=\"getServ\">getServ</a>\n" +
                "<a href=\"postServ\">postServ</a>\n" +
                "<a href=\"putServ\">putServ</a>\n" +
                "<br/>" +
                "<p>Delete user</p>" +
                "<form action='" + req.getContextPath() + "/delServ' method='delete'>" +
                "Name : <input type='text' name='name' />" +
                "<input type='submit'>" +
                "</form>" +
                "</body>\n" +
                "</html>");
        pw.append(sb.toString());
        pw.close();
        String name = req.getParameter("name");
        this.dbController.delete(name);
    }
}
