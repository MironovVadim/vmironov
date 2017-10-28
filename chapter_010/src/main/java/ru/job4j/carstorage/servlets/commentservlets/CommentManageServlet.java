package ru.job4j.carstorage.servlets.commentservlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carstorage.entities.Comment;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * Servlet adds new comment to car.
 */
@WebServlet(name = "commentAdding", urlPatterns = "/carstorage/createComment")
public class CommentManageServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("id");
        int carId = Integer.parseInt(req.getParameter("carId"));
        String description = req.getParameter("description");
        Comment comment = new Comment(description, new Date());
        service.addNewComment(userId, carId, comment);
        PrintWriter out = resp.getWriter();
        this.writeJSON(comment, out);
    }

    /**
     * Method write comment to PrintWriter.
     * @param comment - POJO object.
     * @param out - target.
     * @throws IOException if POJO object could not be written.
     */
    private void writeJSON(Comment comment, PrintWriter out) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, comment);
        out.print(writer.toString());
        out.flush();
    }
}
