package ru.job4j.servlets;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с БД.
 */
public class PostgresDBController implements DBController {

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

    private PostgresDBController() {

    }

    public static PostgresDBController newInstance() {
        if (instance == null) {
            instance = new PostgresDBController();
        }
        return instance;
    }

    @Override
    public List<String> get(int id) {
        List<String> result = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.user WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("name"));
                result.add(resultSet.getString("login"));
                result.add(resultSet.getString("email"));
                result.add(resultSet.getString("create_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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