package ru.job4j.annotationstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.Storage;

/**
 * AnnotationStorage.
 */
@Component
public class AnnotationStorage implements Storage {
    /**
     * Inner Storage.
     */
    private Storage storage;

    /**
     * Default constructor.
     * @param storage - inner storage.
     */
    @Autowired
    public AnnotationStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Storage getter.
     * @return inner storage.
     */
    public Storage getStorage() {
        return storage;
    }
}