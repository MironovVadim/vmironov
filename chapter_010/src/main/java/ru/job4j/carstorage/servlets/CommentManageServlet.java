package ru.job4j.carstorage.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carstorage.Comment;
import ru.job4j.carstorage.User;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CommentManageServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("currentUserId");
        int carId = Integer.parseInt(req.getParameter("carId"));
        String description = req.getParameter("description");
        Comment comment = service.addNewComment(userId, carId, description);
        User userOfComment = comment.getUser();
        DBService.removePrivateInformation(userOfComment);
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, comment);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(writer.toString());
        printWriter.flush();
    }
}
