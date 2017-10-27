package ru.job4j.jdbcstorage;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC storage.
 */
@Component("jdbc")
public class JdbcStorage implements Storage {
    /**
     * Connection pool.
     */
    private static BasicDataSource basicDataSource = new BasicDataSource();

    /**
     * Default constructor.
     * @param user of DB.
     * @param password of DB.
     * @param driverClass - driver class.
     * @param url - url of DB.
     */
    public JdbcStorage(@Value("postgres") String user,
                       @Value("user") String password,
                       @Value("org.postgresql.Driver") String driverClass,
                       @Value("jdbc:postgresql://localhost:5432/Spring_chapter") String url) {
        basicDataSource.setDriverClassName(driverClass);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url);
    }

    @Override
    public boolean addUser(String name, String secondName) {
        boolean result = true;
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO public.user (name, second_name) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, secondName);
            statement.execute();
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}