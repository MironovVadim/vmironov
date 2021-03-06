package ru.job4j.carstorage.servlets.carservlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import ru.job4j.carstorage.entities.Car;
import ru.job4j.carstorage.entities.User;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Car getter Servlet.
 */
@WebServlet(name = "currentCarGetter", urlPatterns = "/carstorage/getCar")
public class CarGetterServlet extends HttpServlet {
    /**
     * Data Base Service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        int carId = Integer.parseInt(req.getParameter("carId"));
        Car car = service.getSpecifiedCar(carId);
        User carUser = car.getUser();
        int userId = (int) req.getSession().getAttribute("id");
        if (userId == carUser.getId()) {
            car.setOwner(true);
        }
        PrintWriter printWriter = resp.getWriter();
        this.writeJSON(car, printWriter);
    }

    /**
     * Method write json to PrintWriter.
     * @param car - POJO object.
     * @param out - target for writing.
     * @throws IOException if POJO object could not be written.
     */
    private void writeJSON(Car car, PrintWriter out) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.setFailOnUnknownId(false);
        mapper.setFilterProvider(provider);
        mapper.writeValue(writer, car);
        out.println(writer.toString());
        out.flush();
    }
}
