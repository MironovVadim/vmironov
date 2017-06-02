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

    /**
     * name length getter.
     * @return name length
     */
    public int getStringLength() {
        return name.length();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (age != user.age) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
