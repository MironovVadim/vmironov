package ru.job4j.todolist.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.todolist.Task;

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
    private static DBService instance;

    /**
     * Private default constructor.
     */
    private DBService() {

    }

    /**
     * Method return instance of singleton.
     * @return instance of class.
     */
    public static synchronized DBService newInstance() {
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
}
