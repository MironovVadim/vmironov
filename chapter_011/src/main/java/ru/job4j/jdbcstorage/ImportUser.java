package ru.job4j.jdbcstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * ImportUser program.
 */
@Component("importUser")
public class ImportUser {
    /**
     * Storage.
     */
    private Storage storage;

    @Autowired
    public ImportUser(Storage storage) {
        this.storage = storage;
    }

    /**
     * Methods adds new User.
     * @param name - user name.
     * @param secondName - user secondName.
     * @return is adding complete.
     */
    public boolean addUser(String name, String secondName) {
         return storage.addUser(name, secondName);
    }

    public Storage getStorage() {
        return storage;
    }
}
