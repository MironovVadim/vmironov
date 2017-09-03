package ru.job4j.jdbcstorage;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ImportUserTest {

    @Test
    public void whenAddUserThenGetTrue() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.getEnvironment().setActiveProfiles("Test");
        ImportUser importUser = (ImportUser) context.getBean("importUser");
        boolean result = importUser.addUser("userName", "userSecondName");
        boolean expected = true;

        assertThat(result, is(expected));
    }

}