package ru.job4j.servlets;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service users DB Controller.
 */
public class PostgresService implements Service {

    /**
     * Singleton DB Controller.
     */
    private static PostgresService instance;
    /**
     * DB Pool.
     */
    private static BasicDataSource basicDataSource = DBConnector.getBasicDataSource();

    /**
     * Private default constructor.
     */
    private PostgresService() {

    }

    /**
     * Singleton pattern.
     * @return DB controller.
     */
    public static synchronized PostgresService newInstance() {
        if (instance == null) {
            instance = new PostgresService();
        }
        return instance;
    }

    @Override
    public List<ServiceUser> getServiceUsers() {
        List<ServiceUser> result = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.service_users")) {
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                String login = set.getString("login");
                String password = set.getString("password");
                String role = this.getServiceRole(set.getInt("user_id"));
                result.add(new ServiceUser(login, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int checkServiceUser(String login, String password) {
        int userId = 0;
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT user_id FROM public.service_users WHERE login = ? AND password = ?")) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                userId = set.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public String getServiceRole(int userId) {
        String result = null;
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT r.role FROM public.role r WHERE r.role_id = (SELECT role_id FROM user_role WHERE user_id = ?)")) {
            preparedStatement.setInt(1, userId);
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            result = set.getString("role");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateServiceUserLogin(String oldLogin, String newLogin) {
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.service_users SET login = ? WHERE login = ?")) {
            preparedStatement.setString(1, newLogin);
            preparedStatement.setString(2, oldLogin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateServiceUserPassword(String login, String newPassword) {
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.service_users SET password = ? WHERE login = ?")) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateServiceUserRole(String login, String newRole) {
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.user_role SET role_id = (SELECT role_id FROM public.role WHERE role = ?) WHERE user_id = (SELECT user_id FROM public.service_users WHERE login = ?)")) {
            preparedStatement.setString(1, newRole);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewUser(String login, String password, String role) {
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement addUserPreparedStatement = connection.prepareStatement("INSERT INTO public.service_users (login, password) VALUES (?, ?)");
             PreparedStatement addRolePreparedStatement = connection.prepareStatement("INSERT INTO public.user_role VALUES ((SELECT user_id FROM public.service_users WHERE login = ?), (SELECT role_id FROM public.role WHERE role = ?))")) {

            addUserPreparedStatement.setString(1, login);
            addUserPreparedStatement.setString(2, password);

            addRolePreparedStatement.setString(1, login);
            addRolePreparedStatement.setString(2, role);

            addUserPreparedStatement.executeUpdate();
            addRolePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
