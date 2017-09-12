package ru.job4j.todolist.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.carstorage.Car;
import ru.job4j.carstorage.Comment;
import ru.job4j.carstorage.User;
import ru.job4j.todolist.Task;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void main(String[] args) {
        Session session = factory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, 1);
        Comment comment = new Comment();
        comment.setUser(car.getUser());
        comment.setDescription("nu kupi yge");
        comment.setCreated(new Date());
        car.getComments().add(comment);
        session.update(car);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
