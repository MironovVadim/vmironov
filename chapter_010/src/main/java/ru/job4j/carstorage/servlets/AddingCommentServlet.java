package ru.job4j.carstorage.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import ru.job4j.carstorage.Comment;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Servlet for adding comments to car.
 */
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
        this.writeJSON(newComment, out);
    }

    /**
     * Method write comment to PrintWriter.
     * @param newComment - POJO object.
     * @param out - target.
     * @throws IOException if POJO object could not be written.
     */
    private void writeJSON(Comment newComment, PrintWriter out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.setFailOnUnknownId(false);
        mapper.setFilterProvider(provider);
        mapper.writeValue(writer, newComment);
        out.print(writer.toString());
        out.flush();
    }
}