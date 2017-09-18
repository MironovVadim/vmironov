package ru.job4j.carstorage.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.CarImage;
import ru.job4j.carstorage.Comment;
import ru.job4j.carstorage.User;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class CarsManageServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = service.getUnsoldCars();
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, carList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("id");
        String mark =  req.getParameter("mark");
        String model = req.getParameter("model");
        int releaseYear = 1990; //Integer.parseInt(req.getParameter("releaseYear"));
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
            List<CarImage> images = new ArrayList<>();
            for (FileItem fileItem: fileItemList) {
                images.add(new CarImage(fileItem.get()));
            }
            service.addNewCar(userId, mark, model, releaseYear, mileage, bodyType, color, engineCapacity, engineType, power, cost, description, images);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
