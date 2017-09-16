package ru.job4j.carstorage.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCarServlet extends HttpServlet {

    private static DBService service = DBService.newInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        String mark =  req.getParameter("mark");
        String model = req.getParameter("model");
        int releaseYear = Integer.parseInt(req.getParameter("releaseYear"));
        int mileage = Integer.parseInt(req.getParameter("mileage"));
        String bodyType = req.getParameter("bodyType");
        String color = req.getParameter("color");
        double engineCapacity = Double.parseDouble(req.getParameter("engineCapacity"));
        String engineType = req.getParameter("engineType");
        int power = Integer.parseInt(req.getParameter("power"));
        int cost = Integer.parseInt(req.getParameter("cost"));
        String description = req.getParameter("description");
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> fileItemList = fileUpload.parseRequest(req);
            List<byte[]> images = new ArrayList<>();
            for (FileItem fileItem: fileItemList) {
                images.add(fileItem.get());
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
