package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Put Servlet.
 *  * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class DoPutServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = PostgresDBController.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
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
                "<br/>" +
                "Name : <input type='text' name='name' />" +
                "<br/>" +
                "<input type='submit'>" +
                "</form>" +
                "<br/>" +
                "</body>\n" +
                "</html>");
        pw.append(sb.toString());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        this.dbController.put(email, name);
    }
}
