package ru.job4j.jdbcstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * AnnotationStorage.
 */
@Component("storage")
public class AnnotationStorage implements Storage {
    /**
     * Inner storage.
     */
    private Storage storage;

    /**
     * Default constructor.
     * @param storage - inner storage.
     */
    @Autowired
    public AnnotationStorage(@Qualifier("innerStorage") Storage storage) {
        this.storage = storage;
    }

    /**
     * storage getter.
     * @return inner storage.
     */
    public Storage getStorage() {
        return storage;
    }

    @Override
    public boolean addUser(String name, String secondName) {
        return false;
    }
}