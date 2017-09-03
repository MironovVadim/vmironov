package ru.job4j.jdbcstorage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Production")
public class JdbcStorageProfile implements StorageProfile {

    @Override
    @Bean
    public Storage createStorage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring-configuration.xml");
        Storage storage = (JdbcStorage) context.getBean("jdbc");
        return storage;
    }
}
