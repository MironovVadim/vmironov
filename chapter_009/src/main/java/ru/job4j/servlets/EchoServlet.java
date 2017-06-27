package ru.job4j.servlets;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet.
 */
public class EchoServlet extends HttpServlet {
    /**
     * Server address.
     */
    private static final String URL = "jdbc:postgresql:5432//localhost/UserDB";
    /**
     * Login and password.
     */
    private static final Properties PROPERTIES = new Properties();
    static {
        PROPERTIES.setProperty("login", "postgres");
        PROPERTIES.setProperty("password", "user");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (Connection connection = DriverManager.getConnection(URL, PROPERTIES)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            int id = Integer.parseInt(req.getParameter("id"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintWriter pw = new PrintWriter(resp.getOutputStream());
            while (resultSet.next()) {
                pw.append("name:" + resultSet.getString("name")
                        + " login:" + resultSet.getString("login")
                        + " email: " + resultSet.getString("email"));
                pw.flush();
            }
            resultSet.close();
            preparedStatement.close();
            pw.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (Connection connection = DriverManager.getConnection(URL, PROPERTIES)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (name, login, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.setString(2, req.getParameter("login"));
            preparedStatement.setString(3, req.getParameter("email"));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (Connection connection = DriverManager.getConnection(URL, PROPERTIES)) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET email = ? WHERE name = ?");
            preparedStatement.setString(1, req.getParameter("email"));
            preparedStatement.setString(2, req.getParameter("name"));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (Connection connection = DriverManager.getConnection(URL, PROPERTIES)) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE name = ?");
            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
