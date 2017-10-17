package ru.job4j.carstorage.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.Image;
import ru.job4j.carstorage.User;
import ru.job4j.carstorage.json.JSONCarWriter;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Getter/Setter car servlet.
 */
public class CarsManageServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        List<Car> carList = service.getUnsoldCars();
        int userId = (int) req.getSession().getAttribute("id");
        for (Car car : carList) {
            User user = car.getUser();
            if (userId == user.getId()) {
                car.setOwner(true);
            }
        }
        PrintWriter out = resp.getWriter();
        JSONCarWriter.writeJSONCars(carList, out);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
            Map<String, String> fields = new HashMap<>();
            List<Image> images = new ArrayList<>();

            try {
                List<FileItem> fileItemList = fileUpload.parseRequest(req);
                for (FileItem fileItem : fileItemList) {
                    if (fileItem.isFormField()) {
                        fields.put(fileItem.getFieldName(), fileItem.getString());
                    } else {
                        images.add(new Image(fileItem.get()));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            int userId = (int) req.getSession().getAttribute("id");
            String mark = fields.get("mark");
            String model = fields.get("model");
            int releaseYear = Integer.parseInt(fields.get("releaseYear"));
            int mileage = Integer.parseInt(fields.get("mileage"));
            String bodyType = fields.get("bodyType");
            String color = fields.get("color");
            double engineCapacity = Double.parseDouble(fields.get("engineCapacity"));
            String engineType = fields.get("engineType");
            int power = Integer.parseInt(fields.get("power"));
            int cost = Integer.parseInt(fields.get("cost"));
            String description = fields.get("description");
            service.addNewCar(userId, mark, model, releaseYear, mileage, bodyType, color, engineCapacity, engineType, power, cost, description, images);
        }
    }
}