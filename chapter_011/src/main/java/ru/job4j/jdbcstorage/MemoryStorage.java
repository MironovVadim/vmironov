package ru.job4j.jdbcstorage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Memory storage.
 */
@Component("memory")
public class MemoryStorage implements Storage {
    /**
     * User storage.
     */
    private List<User> list = new ArrayList<>();

    @Override
    public boolean addUser(String name, String secondName) {
        return this.list.add(new User(name, secondName));
    }

    /**
     * Inner class - User.
     */
    class User {
        /**
         * User name.
         */
        private String name;
        /**
         * User second name.
         */
        private String secondName;

        /**
         * Default constructor.
         * @param name of user.
         * @param secondName of user.
         */
        User(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }

        /**
         * Name getter.
         * @return name.
         */
        public String getName() {
            return name;
        }

        /**
         * SecondName getter.
         * @return second name.
         */
        public String getSecondName() {
            return secondName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;

            if (!name.equals(user.name)) {
                return false;
            }
            return secondName.equals(user.secondName);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + secondName.hashCode();
            return result;
        }
    }
}
