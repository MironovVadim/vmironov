package ru.job4j.jdbcstorage;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC storage.
 */
@Resource(name = "jdbcStorage")
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
    public JdbcStorage(@Value("postgres") String user, @Value("user") String password,
                       @Value("org.postgresql.Driver") String driverClass,
                       @Value("jdbc:postgresql://localhost:5432/Spring_chapter") String url) {
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        basicDataSource.setDriverClassName(driverClass);
        basicDataSource.setUrl(url);
    }

    @Override
    public boolean addUser(String name, String secondName) {
        boolean result = false;
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO public.user (name, secondName) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, secondName);
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
