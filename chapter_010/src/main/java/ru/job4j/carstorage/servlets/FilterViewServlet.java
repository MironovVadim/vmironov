package ru.job4j.carstorage.servlets;

import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.User;
import ru.job4j.carstorage.json.JSONCarWriter;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterViewServlet extends HttpServlet {
    /**
     * Data Base service.
     */
    private static DBService service = DBService.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        int userId = (int) req.getSession().getAttribute("id");
        Map<String, String> filters = new HashMap<>();
        this.fillFilters(filters, req);
        List<Car> filterCars = service.getFilterCars(filters);
        for (Car car : filterCars) {
            User user = car.getUser();
            if (userId == user.getId()) {
                car.setOwner(true);
            }
        }
        PrintWriter out = resp.getWriter();
        JSONCarWriter.writeJSONCars(filterCars, out);
    }

    private void fillFilters(Map<String, String> filters, HttpServletRequest req) {
        String mark = req.getParameter("mark");
        String model = req.getParameter("model");
        String costFromStr = req.getParameter("costFrom");
        String costToStr = req.getParameter("costTo");
        if (mark.length() != 0) {
            filters.put("mark", mark);
        }
        if (model.length() != 0) {
            filters.put("model", model);
        }
        if (costFromStr.length() != 0) {
            filters.put("costFrom", costFromStr);
        }
        if (costToStr.length() != 0) {
            filters.put("costTo", costToStr);
        }
    }
}
