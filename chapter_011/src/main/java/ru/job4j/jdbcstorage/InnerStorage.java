package ru.job4j.jdbcstorage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * InnerStorage.
 */
@Component("innerStorage")
public class InnerStorage implements Storage {

    @Override
    public boolean addUser(String name, String secondName) {
        return false;
    }
}
