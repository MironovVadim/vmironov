/**
 * User class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.sort;

/**
 * User class.
 */
public class User implements Comparable<User> {
    /**
     * User age.
     */
    private int age;
    /**
     * User name.
     */
    private String name;

    /**
     * Constructor.
     * @param age - user age
     * @param name - user name
     */
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + '}';
    }
}
