package ru.job4j.servlets;

/**
 * Service user.
 */
public class ServiceUser {
    /**
     * User login.
     */
    private String login;
    /**
     * User password.
     */
    private String password;
    /**
     * User role.
     */
    private String role;

    /**
     * Default constructor.
     * @param login - user login.
     * @param password - user password.
     * @param role - user role.
     */
    public ServiceUser(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * Login getter.
     * @return user login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Password getter.
     * @return user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Role getter.
     * @return user role.
     */
    public String getRole() {
        return role;
    }
}
