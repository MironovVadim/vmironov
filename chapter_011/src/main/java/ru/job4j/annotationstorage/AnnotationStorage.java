package ru.job4j.annotationstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.Storage;

/**
 * AnnotationStorage.
 */
@Service("Storage")
public class AnnotationStorage implements Storage {
    /**
     * Inner storage.
     */
    private Storage storage;

    /**
     * Default constructor.
     * @param storage - inner storage.
     */
    public AnnotationStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * storage getter.
     * @return inner storage.
     */
    @Autowired
    public Storage getStorage() {
        return storage;
    }
}