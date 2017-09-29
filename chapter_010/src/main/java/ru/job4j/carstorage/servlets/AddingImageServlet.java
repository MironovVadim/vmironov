package ru.job4j.carstorage.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.carstorage.Image;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddingImageServlet extends HttpServlet {

    private static DBService service = DBService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        List<Image> images = new ArrayList<>();
        try {
            List<FileItem> fileItemList = fileUpload.parseRequest(req);
            for (FileItem fileItem: fileItemList) {
                images.add(new Image(fileItem.get()));
            }
            service.addImagesToCar(1, images);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/carstorage/addCar.html", req.getContextPath()));
    }
}
