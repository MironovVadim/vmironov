package ru.job4j.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.CarImage;
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
     * @param cost of car.
     * @param description of car.
     * @param images of car.
     */
    public void addNewCar(int userId, String mark, String model, int releaseYear, int mileage, String bodyType, String color, double engineCapacity, String engineType, int power, int cost, String description, List<CarImage> images) {
        boolean sold = false;
        Date date = new Date();
        Session session = factory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        Car car = new Car(user, mark, model, releaseYear, mileage, bodyType, color, engineCapacity, engineType, power, cost, sold, description, date, images);
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    public int addNewUser() {
        return 0;
    }
}
