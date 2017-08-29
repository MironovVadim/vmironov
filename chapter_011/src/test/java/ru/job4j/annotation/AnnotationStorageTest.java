package ru.job4j.annotation;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.annotationstorage.AnnotationStorage;

import static org.junit.Assert.assertNotNull;

/**
 * Test class.
 */
public class AnnotationStorageTest {
    /**
     * Spring test.
     */
    @Test
    public void whenCreateStorageThenGetInnerStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        AnnotationStorage storage = context.getBean(AnnotationStorage.class);
        assertNotNull(storage.getStorage());
    }
}
