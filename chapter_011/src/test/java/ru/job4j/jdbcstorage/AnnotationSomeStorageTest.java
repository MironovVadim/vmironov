package ru.job4j.jdbcstorage;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertNotNull;

/**
 * Test class.
 */
@Component
public class AnnotationSomeStorageTest {
    /**
     * Spring test.
     */
    @Test
    public void whenCreateStorageThenGetInnerStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        AnnotationStorage storage = (AnnotationStorage) context.getBean("storage");
        assertNotNull(storage.getStorage());
    }
}
