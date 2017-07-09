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
public class DoGetServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = new PostgresDBController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        String result = this.dbController.get(id);
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
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
                result +
                "</body>\n" +
                "</html>");
        pw.append(sb.toString());
        pw.close();
    }
}
