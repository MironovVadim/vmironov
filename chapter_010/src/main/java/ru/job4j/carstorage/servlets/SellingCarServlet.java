package ru.job4j.carstorage.servlets;

import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SellingCarServlet extends HttpServlet {

    private static DBService service = DBService.newInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("carId"));
        int userId = (int) req.getSession().getAttribute("id");
        service.sellCar(carId, userId);
    }
}
