package ru.job4j.jdbcstorage;

import org.springframework.stereotype.Component;

/**
 * InnerStorage.
 */
@Component
public class InnerStorage implements Storage {

    @Override
    public boolean addUser(String name, String secondName) {
        return false;
    }
}
