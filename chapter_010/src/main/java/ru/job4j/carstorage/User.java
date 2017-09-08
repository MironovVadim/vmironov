package ru.job4j.carstorage;

import java.util.Date;

/**
 * User.
 */
public class User {
    /**
     * Id.
     */
    private int id;
    /**
     * Name.
     */
    private String name;
    /**
     * Second name.
     */
    private String secondName;
    /**
     * Login.
     */
    private String login;
    /**
     * Password.
     */
    private String password;
    /**
     * Created Date.
     */
    private Date created;

    /**
     * Id getter.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
     * @param id - id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Name getter.
     * @return name;
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Second name getter.
     * @return second name.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Second name setter.
     * @param secondName - second name.
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Login getter.
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Login setter.
     * @param login - login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Password getter.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Password setter.
     * @param password - password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Created date getter.
     * @return date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Created date setter.
     * @param created - created date.
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}
