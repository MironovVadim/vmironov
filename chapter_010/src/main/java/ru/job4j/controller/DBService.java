package ru.job4j.controller;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.carstorage.entities.Car;
import ru.job4j.carstorage.entities.Comment;
import ru.job4j.carstorage.entities.User;
import ru.job4j.todolist.entities.Task;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Class managing the Data Base.
 */
public class DBService {
    /**
     * Connection factory.
     */
    private static SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();
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
     * Method return List of tasks.
     * @return tasks.
     */
    public List<Task> getTasks() {
        Session session = factory.openSession();
        List tasks = session.createQuery("FROM Task ORDER BY created").list();
        session.close();
        return tasks;
    }

    /**
     * Method adds new car to DB.
     * @param car - car entity.
     * @param userId of car.
     * @return car id.
     */
    public int addNewCar(Car car, int userId) {
        Session session = factory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        car.setUser(user);
        session.save(car);
        session.getTransaction().commit();
        session.close();
        return car.getId();
    }

    /**
     * Method adds new User in DB.
     * @param user - user entity.
     * @return user id.
     */
    public int addNewUser(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user.getId();
    }

    /**
     * Method checks existence of user.
     * @param userLogin of user.
     * @param userPassword of user.
     * @return user id.
     */
    public int checkUser(String userLogin, String userPassword) {
        int result;
        Session session = factory.openSession();
        session.beginTransaction();
        Integer userId = (Integer) session
                .createQuery("SELECT id FROM User WHERE login = :currLogin AND password = :currPassword")
                .setParameter("currLogin", userLogin)
                .setParameter("currPassword", userPassword)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        if (userId == null) {
            result = -1;
        } else {
            result = userId;
        }
        return result;
    }

    /**
     * Method adds new comment in DB.
     * @param userId of user which do comment.
     * @param carId of car which contains comment.
     * @param comment at car.
     * @return created comment.
     */
    public Comment addNewComment(int userId, int carId, Comment comment) {
        Session session = factory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, carId);
        User user = session.get(User.class, userId);
        comment.setUser(user);
        car.getComments().add(comment);
        session.update(car);
        session.getTransaction().commit();
        session.close();
        return comment;
    }

    /**
     * Method returns List of all unsold cars.
     * @return List of all unsold cars.
     */
    public List<Car> getUnsoldCars() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Car> carList = session.createQuery("FROM Car ORDER BY created DESC")
                .list();
        for (Car car : carList) {
            Hibernate.initialize(car.getUser());
            Hibernate.initialize(car.getImages());
        }
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
        if (car != null) {
            Hibernate.initialize(car.getUser());
            Hibernate.initialize(car.getComments());
            Hibernate.initialize(car.getImages());
        }
        session.getTransaction().commit();
        session.close();
        return car;
    }

    /**
     * Method checks existence of user login.
     * @param userLogin in data base.
     * @return is login exist.
     */
    public boolean isUserLoginExist(String userLogin) {
        Session session = factory.openSession();
        session.beginTransaction();
        long count = (long) session.createQuery("SELECT count(login) FROM User WHERE login = :currLogin")
                .setParameter("currLogin", userLogin)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return count != 0;
    }

    /**
     * Method closes hibernate factory.
     */
    public void closeFactory() {
        factory.close();
    }

    /**
     * Method set field sold equals true.
     * @param carId of car.
     * @param userId of user.
     */
    public void sellCar(int carId, int userId) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Car SET sold = true WHERE id = :currId AND user.id = :currUserId")
                .setParameter("currId", carId)
                .setParameter("currUserId", userId).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Method returns list of filtered cars.
     * @param filters for cars.
     * @return filtered cars as List.
     */
    public List<Car> getFilteredCars(Map<String, String> filters) {
        Session session = factory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = factory.getCriteriaBuilder();
        CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
        Root<Car> rootCar = criteria.from(Car.class);
        criteria.select(rootCar);
        this.addFilters(builder, criteria, rootCar, filters);
        TypedQuery<Car> query = session.createQuery(criteria);
        List<Car> filterCars = query.getResultList();
        for (Car car : filterCars) {
            Hibernate.initialize(car.getUser());
            Hibernate.initialize(car.getImages());
        }
        session.getTransaction().commit();
        session.close();
        return filterCars;
    }

    /**
     * Method adds filters in query to DB.
     * @param builder - object which creates conditions of query.
     * @param query of DB entity.
     * @param rootCar - object entity of DB.
     * @param filters - map with values of filter conditions.
     */
    private void addFilters(CriteriaBuilder builder, CriteriaQuery<Car> query, Root<Car> rootCar, Map<String, String> filters) {
        Predicate searchPattern = builder.equal(rootCar.get("sold"), false);

        String mark = filters.get("mark");
        String model = filters.get("model");
        String costFrom = filters.get("costFrom");
        String costTo = filters.get("costTo");

        if (mark != null) {
            mark = "%" + mark.toLowerCase() + "%";
            searchPattern = builder.and(searchPattern,
                    builder.like(builder.lower(rootCar.get("mark")),
                    mark));
        }
        if (model != null) {
            model = "%" + model.toLowerCase() + "%";
            searchPattern = builder.and(searchPattern,
                    builder.like(builder.lower(rootCar.get("model")),
                    model));
        }
        if (costFrom != null && costTo != null) {
            int from = Integer.parseInt(costFrom);
            int to = Integer.parseInt(costTo);
            if (from <= to) {
                searchPattern = builder.and(searchPattern, builder.between(
                        rootCar.get("cost"), from, to));
            }
        } else if (costFrom != null) {
            int from = Integer.parseInt(costFrom);
            searchPattern = builder.and(searchPattern, builder.greaterThanOrEqualTo(
                    rootCar.get("cost"), from));
        } else if (costTo != null) {
            int to = Integer.parseInt(costTo);
            searchPattern = builder.and(searchPattern, builder.lessThanOrEqualTo(
                    rootCar.get("cost"), to));
        }
        query.where(searchPattern);
    }

    public static void main(String[] args) {
        DBService.newInstance();
    }
}