package ru.job4j.servlets;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB Connector - Singleton.
 */
public class DBConnector {
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
     * Default constructor.
     */
    private DBConnector() {

    }

    /**
     * Singleton.
     * @return DBP.
     */
    public static BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }
}
