package ru.job4j.controller;

import org.junit.Test;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.Comment;
import ru.job4j.carstorage.Image;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test class fo DBService class.
 */
public class DBServiceTest {
    /**
     * Data base service.
     */
    private static DBService service = DBService.newInstance();
    /**
     * User id.
     */
    private static int userId = 1;
    /**
     * User nickname.
     */
    private static String nickname = "nickname";
    /**
     * User login.
     */
    private static String login = "login";
    /**
     * User password.
     */
    private static String password = "password";

    /**
     * Car id.
     */
    private static int carId = 1;
    /**
     * Car mark.
     */
    private static String mark = "Toyota";
    /**
     * Car model.
     */
    private static String model = "Prius";
    /**
     * Car release year.
     */
    private static int releaseYear = 2017;
    /**
     * Car mileage.
     */
    private static int mileage = 0;
    /**
     * Car body type.
     */
    private static String bodyType = "bodyType";
    /**
     * Car color.
     */
    private static String color = "Red";
    /**
     * Car engine capacity.
     */
    private static double engineCapacity = 0.0;
    /**
     * Car engine type.
     */
    private static String engineType = "Electric";
    /**
     * Car power.
     */
    private static int power = 300;
    /**
     * Car cost.
     */
    private static int cost = 7000;
    /**
     * Car description.
     */
    private static String description = "description";
    /**
     * Car comment.
     */
    private static String comment = "Some comment";

    static {
        service.addNewUser(nickname, login, password);
        List<Image> images = new ArrayList<>();
        service.addNewCar(userId, mark, model, releaseYear, mileage, bodyType, color, engineCapacity,
                engineType, power, cost, description, images);
        String anotherMark = "Ford";
        String anotherModel = "Focus";
        int anotherCost = 5000;
        images = new ArrayList<>();
        service.addNewCar(userId, anotherMark, anotherModel, releaseYear, mileage, bodyType, color, engineCapacity,
                engineType, power, anotherCost, description, images);
    }

    /**
     * Method checks checkUser(login, password) method.
     */
    @Test
    public void whenCheckUserThenGetMinusOne() {
        String nonExistenceLogin = "nonExLogin";
        String nonExistencePass = "nonExPass";
        int result = service.checkUser(nonExistenceLogin, nonExistencePass);
        assertEquals(-1, result);
    }

    /**
     * Method checks isUserLoginExist(login) method.
     */
    @Test
    public void whenCheckExistenceLoginThenGetNotZero() {
        assertTrue(service.isUserLoginExist(login));
    }

    /**
     * Method tests isUserLoginExist(login) method.
     */
    @Test
    public void whenCheckExistenceLoginThenGetFalse() {
        String notExistenceLogin = "anotherLogin";
        assertFalse(service.isUserLoginExist(notExistenceLogin));
    }

    /**
     * Method tests getUnsoldCars() method.
     */
    @Test
    public void whenInvokeGetUnsoldCarsThenGetTwoCars() {
        assertEquals(2, service.getUnsoldCars().size());
    }

    /**
     * Method tests sellCar(carId, userId) method.
     */
    @Test
    public void whenSellCarThenGetTwoCars() {
        List<Image> images = new ArrayList<>();
        int newCarId = service.addNewCar(userId, mark, model, releaseYear, mileage, bodyType, color, engineCapacity,
                engineType, power, cost, description, images);
        List<Car> carList = service.getUnsoldCars();

        assertEquals(3, carList.size());

        service.sellCar(newCarId, userId);
        carList = service.getUnsoldCars();

        assertEquals(2, carList.size());
    }

    /**
     * Method tests addNewComment(comment) method.
     */
    @Test
    public void whenAddNewCommentThenGetThisComment() {
        service.addNewComment(userId, carId, comment);
        Set<Comment> commentList = service
                .getSpecifiedCar(carId)
                .getComments();
        assertNotEquals(0, commentList.size());
    }

    /**
     * Method tests getFilteredCars(filters) method with mark option.
     */
    @Test
    public void whenFilterMarkThenGetOneCar() {
        Map<String, String> filters = new HashMap<>();
        filters.put("mark", "toyo");
        List<Car> carList = service.getFilteredCars(filters);

        assertEquals(1, carList.size());
        assertEquals("toyota", carList.get(0).getMark().toLowerCase());
    }

    /**
     * Method tests getFilteredCars(filters) method with model option.
     */
    @Test
    public void whenFilterModelThenGetOneCar() {
        Map<String, String> filters = new HashMap<>();
        filters.put("model", "rius");
        List<Car> carList = service.getFilteredCars(filters);

        assertEquals(1, carList.size());
        assertEquals("prius", carList.get(0).getModel().toLowerCase());
    }

    /**
     * Method tests getFilteredCars(filters) method with cost option.
     */
    @Test
    public void whenFilterCostFromThenGetTwoCars() {
        Map<String, String> filters = new HashMap<>();
        filters.put("costFrom", "4000");
        List<Car> carList = service.getFilteredCars(filters);

        assertEquals(2, carList.size());
    }

    /**
     * Method tests getFilteredCars(filters) method with cost options.
     */
    @Test
    public void whenFilterCostFromToThenGetOneCar() {
        Map<String, String> filters = new HashMap<>();
        filters.put("costFrom", "6000");
        filters.put("costTo", "8000");
        List<Car> carList = service.getFilteredCars(filters);

        assertEquals(1, carList.size());
    }
}