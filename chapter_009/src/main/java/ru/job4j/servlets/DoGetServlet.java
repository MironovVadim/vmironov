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
        /*
        int id = Integer.parseInt(req.getParameter("id"));
        String result = this.dbController.get(id);
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
        if (result != null) {
            pw.append(result);
        } else {
            pw.append("User'a с таким id в БД нет.");
        }
        pw.close();
        */
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true);
        pw.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "someText\n" +
                "</body>\n" +
                "</html>");
        pw.close();
    }
}
