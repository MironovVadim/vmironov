package ru.job4j.carstorage.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.User;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CarGetterServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("carId"));
        Car car = service.getSpecifiedCar(carId);
        User carUser = car.getUser();
        int userId = (int) req.getSession().getAttribute("currentUserId");
        if (userId == carUser.getId()) {
            car.setOwner(true);
        }
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, car);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(writer.toString());
        printWriter.flush();
    }
}
