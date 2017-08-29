package ru.job4j;

/**
 * UserStorage.
 */
public class UserStorage implements Storage {
    /**
     * Inner storage.
     */
    private Storage storage;

    /**
     * Default constructor.
     * @param storage - inner storage.
     */
    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Storage getter.
     * @return storage.
     */
    public Storage getStorage() {
        return storage;
    }
}
