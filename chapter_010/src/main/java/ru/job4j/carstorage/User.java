package ru.job4j.carstorage;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * User.
 */
@JsonAutoDetect
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    /**
     * Id.
     */
    private int id;
    /**
     * Name.
     */
    private String nickname;
    /**
     * Login.
     */
    @JsonIgnore
    private String login;
    /**
     * Password.
     */
    @JsonIgnore
    private String password;
    /**
     * Created Date.
     */
    private Date created;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Second constructor with initialization fields.
     * @param nickname of user.
     * @param login of user.
     * @param password of user.
     * @param created date of user.
     */
    public User(String nickname, String login, String password, Date created) {
        this.nickname = nickname;
        this.login = login;
        this.password = password;
        this.created = created;
    }

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
    public String getNickname() {
        return nickname;
    }

    /**
     * nickname setter.
     * @param nickname - nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!nickname.equals(user.nickname)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        return created.equals(user.created);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nickname.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + created.hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                '}';
    }
}
