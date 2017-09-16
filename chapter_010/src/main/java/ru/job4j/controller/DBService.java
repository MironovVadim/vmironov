package ru.job4j.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.CarImage;
import ru.job4j.carstorage.Comment;
import ru.job4j.carstorage.User;
import ru.job4j.todolist.Task;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Class managing the Data Base.
 */
public class DBService {
    /**
     * Connection factory.
     */
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    /**
     * Singleton.
     */
    private static DBService instance = new DBService();

    /**
     * Private default constructor.
     */
    private DBService() {
    }

    /**
     * Method return instance of singleton.
     * @return instance of class.
     */
    public static DBService newInstance() {
        if (instance == null) {
            instance = new DBService();
        }
        return instance;
    }

    public static void removePrivateInformation(User user) {
        user.setLogin(null);
        user.setPassword(null);
    }

    /**
     * Method adds new Task.
     * @param desc - description of task.
     */
    public void addNewTask(String desc) {
        Session session = factory.openSession();
        session.beginTransaction();
        Task task = new Task();
        task.setDesc(desc);
        task.setCreated(new Date());
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Method return List of tasks.
     * @return tasks.
     */
    public List<Task> getTasks() {
        Session session = factory.openSession();
        List tasks = session.createQuery("FROM Task").list();
        session.close();
        return tasks;
    }

    /**
     * Method completes task.
     * @param id of task which completed.
     */
    public void completeTask(String id) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createQuery("update Task set done = :isDone where id = :currentId")
                .setParameter("isDone", true)
                .setParameter("currentId", Integer.parseInt(id))
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Method adds new car to DB.
     * @param userId of car.
     * @param mark of car.
     * @param model of car.
     * @param releaseYear of car.
     * @param mileage of car.
     * @param bodyType of car.
     * @param color of car.
     * @param engineCapacity of car.
     * @param engineType of car.
     * @param power of car.
     * @param description of car.
     * @param images of car.
     */
    public void addNewCar(int userId, String mark, String model, int releaseYear, int mileage, String bodyType, String color, double engineCapacity, String engineType, int power, int cost, String description, List<CarImage> images) {
        Session session = factory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        Date createdDate = new Date();
        Car car = new Car(user, mark, model, releaseYear, mileage, bodyType, color, engineCapacity, engineType, power, cost, description, createdDate, images);
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Method adds new User in DB.
     * @param nickname of user.
     * @param login of user.
     * @param password of user.
     * @return user id.
     */
    public int addNewUser(String nickname, String login, String password) {
        Session session = factory.openSession();
        session.beginTransaction();
        Date createdDate = new Date();
        User user = new User(nickname, login, password, createdDate);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user.getId();
    }

    /**
     * Method adds new comment in DB.
     * @param userId of user which do comment.
     * @param carId of car which contains comment.
     * @param description of comment.
     * @return created comment.
     */
    public Comment addNewComment(int userId, int carId, String description) {
        Session session = factory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, carId);
        User user = session.get(User.class, userId);
        Date createdDate = new Date();
        Comment comment = new Comment(user, description, createdDate);
        car.getComments().add(comment);
        session.update(car);
        return comment;
    }

    /**
     * Method returns List of all unsold cars.
     * @return List of all unsold cars.
     */
    public List<Car> getUnsoldCars() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Car> carList = session.createQuery("FROM Car WHERE sold = false ORDER BY created").list();
        session.getTransaction().commit();
        session.close();
        return carList;
    }

    /**
     * Method returns car by car id.
     * @param carId of car.
     * @return car with specified id.
     */
    public Car getSpecifiedCar(int carId) {
        Session session = factory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, carId);
        session.getTransaction().commit();
        session.close();
        return car;
    }
}
