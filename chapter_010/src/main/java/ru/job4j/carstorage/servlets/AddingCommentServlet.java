package ru.job4j.carstorage.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carstorage.Comment;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AddingCommentServlet extends HttpServlet {
    /**
     * Data base service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        int userId = (int) req.getSession().getAttribute("id");
        int carId = Integer.parseInt(req.getParameter("carId"));
        String description = req.getParameter("description");

        Comment newComment = service.addNewComment(userId, carId, description);

        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, newComment);
        out.print(writer.toString());
        out.flush();
    }
}
