package ru.job4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * UserStorage.
 */
public class UserStorageTest {
    /**
     * Spring test.
     */
    @Test
    public void whenCreateStorageThenGetInnerStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        assertNotNull(storage.getStorage());
    }
}
