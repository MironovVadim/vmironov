package ru.job4j.jdbcstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * ImportUser program.
 */
@Resource(name = "importUser")
public class ImportUser {
    /**
     * Storage.
     */
    private Storage storage;

    @Autowired
    public ImportUser(@Qualifier("JdbcStorage") Storage storage) {
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
}
