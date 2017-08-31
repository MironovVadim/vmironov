package ru.job4j;

/**
 * MemoryStorage.
 */
public class MemoryStorage implements Storage {
    /**
     * Name.
     */
    private String name;

    /**
     * Getter.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
