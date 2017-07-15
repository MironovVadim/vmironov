package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Post Servlet.
 *  * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class DoPostServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController = PostgresDBController.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
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
                "<br/>" +
                "Login : <input type='text' name='login' />" +
                "<br/>" +
                "Email : <input type='text' name='email' />" +
                "<br/>" +
                "<input type='submit'>" +
                "</form>" +
                "<br/>" +
                "</body>\n" +
                "</html>");
        pw.append(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        this.dbController.post(name, login, email);
    }
}
