package ru.job4j.servlets;

import java.util.List;

/**
 * ServiceUser tables controller.
 */
public interface Service {
    /**
     * Method return service users.
     * @return service users.
     */
    List<ServiceUser> getServiceUsers();

    /**
     * Authorisation method.
     * @param login - user login.
     * @param password - user password.
     * @return user id.
     */
    int checkServiceUser(String login, String password);

    /**
     * Method returns role of user.
     * @param userId - user id.
     * @return Role
     */
    String getServiceRole(int userId);

    /**
     * Method updates service user login.
     * @param oldLogin - old name.
     * @param newLogin - new name.
     */
    void updateServiceUserLogin(String oldLogin, String newLogin);

    /**
     * Method updates password.
     * @param name - user name.
     * @param newPassword - new password.
     */
    void updateServiceUserPassword(String name, String newPassword);

    /**
     * Method update user role.
     * @param login - user login.
     * @param newRole - new role.
     */
    void updateServiceUserRole(String login, String newRole);

    /**
     * Method Adds new service user.
     * @param login - user login.
     * @param password - user password.
     * @param role - user role.
     */
    void addNewUser(String login, String password, String role);
}
