package ru.job4j.servlets;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс для работы с БД.
 */
public class PostgresDBController implements DBController {
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

    @Override
    public String get(int id) {
        StringBuilder result = new StringBuilder("<table>");
        result.append("<tr><th>Name</th><th>Login</th><th>Email</th><th>CreateDate</th></tr>");
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.user WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.append("<tr><td>" + resultSet.getString("name") + "</td><td>" +
                                resultSet.getString("login") + "</td><td>" +
                                resultSet.getString("email") +
                                "</td><td>" + resultSet.getDate("create_date") + "</td></tr>");
            }
            result.append("</table>");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    public void post(String name, String login, String email) {
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.user (name, login, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void put(String email, String name) {
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.user SET email = ? WHERE name = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.user WHERE name = ?");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}