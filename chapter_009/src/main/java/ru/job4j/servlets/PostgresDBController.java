package ru.job4j.servlets;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс для работы с БД.
 *  * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class PostgresDBController implements DBController {
    /**
     * Singleton DB.
     */
    private static PostgresDBController instance;
    /**
     * Server address.
     */
    private static final String URL = "jdbc:postgresql://localhost:5432/UserDB";
    /**
     * User password.
     */
    private static final String PASSWORD = "user";
    /**
     * User name.
     */
    private static final String USER = "postgres";
    /**
     * Pool.
     */
    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
    }

    /**
     * Private default constructor.
     */
    private PostgresDBController() {

    }

    /**
     * Singleton pattern.
     * @return DB controller.
     */
    public static PostgresDBController newInstance() {
        if (instance == null) {
            instance = new PostgresDBController();
        }
        return instance;
    }

    @Override
    public List<User> get() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                Date createDate = resultSet.getDate("create_date");
                userList.add(new User(name, login, email, createDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void post(String name, String login, String email) {
        try (Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.user (name, login, email) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void put(String email, String name) {
        try (Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.user SET email = ? WHERE name = ?")) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try (Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.user WHERE name = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}