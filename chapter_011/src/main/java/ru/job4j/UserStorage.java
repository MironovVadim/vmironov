package ru.job4j;

/**
 * UserStorage.
 */
public class UserStorage implements Storage {
    /**
     * Inner storage.
     */
    private MemoryStorage storage;

    /**
     * Default constructor.
     * @param storage - inner storage.
     */
    public UserStorage(MemoryStorage storage) {
        this.storage = storage;
    }

    /**
     * storage getter.
     * @return storage.
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Setter.
     * @param storage - storage.
     */
    public void setStorage(MemoryStorage storage) {
        this.storage = storage;
    }

    /**
     * Getter.
     * @return name
     */
    public String getName() {
        return this.storage.getName();
    }
}
