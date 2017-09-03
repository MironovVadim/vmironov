package ru.job4j.jdbcstorage;

/**
 * Some storage.
 */
public interface Storage {
    /**
     * Method adds new user in storage.
     * @param name of user.
     * @param secondName of user.
     * @return is adding complete.
     */
    boolean addUser(String name, String secondName);
}
