/**
 * Bank user.
 *
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.bank;

/**
 * Class User.
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User passport.
     */
    private int passport;

    /**
     * Coustructor.
     * @param name of user
     * @param passport of user
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (passport != user.passport) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }
}
