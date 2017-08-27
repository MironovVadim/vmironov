package ru.job4j.todolist.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.todolist.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Controller servlet.
 */
public class ControlServlet extends HttpServlet {
    /**
     * DB service class.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, service.getItems());
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(writer.toString());
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("description");
        service.addNewTask(desc);
    }
}
