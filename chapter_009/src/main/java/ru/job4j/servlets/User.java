package ru.job4j.servlets;

import java.util.Date;

/**
 * Data Base User.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 * */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User login.
     */
    private String login;
    /**
     * User email.
     */
    private String email;
    /**
     * Create date.
     */
    private Date createDate;

    /**
     * Default constructor.
     * @param name - user name.
     * @param login - user login.
     * @param email - user email.
     * @param createDate - create date.
     */
    public User(String name, String login, String email, Date createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Name getter.
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Login getter.
     * @return user login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Email getter.
     * @return user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Create date getter.
     * @return create date.
     */
    public Date getCreateDate() {
        return createDate;
    }
}
