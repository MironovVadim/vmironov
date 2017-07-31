/**
 * Test ConvertList class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.sort;

import org.junit.Test;
import ru.job4j.sort.SortUser;
import ru.job4j.sort.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Test class.
 */
public class SortUserTest {
    /**
     * Test method.
     */
    @Test
    public void whenConvertListThenGetSortedSet() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        User user0 = new User(25, "Vadim");
        User user1 = new User(20, "Maks");
        User user2 = new User(28, "Michail");
        Collections.addAll(list, user0, user1, user2);
        Set<User> set = sortUser.sort(list);
        StringJoiner sj = new StringJoiner(" : ");
        for (User user : set) {
            sj.add(user.toString());
        }
        String result = sj.toString();
        String expected = new StringJoiner(" : ").add(user1.toString()).add(user0.toString()).add(user2.toString()).toString();
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenSortListByHashCodeThenGetSortedList() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        User user0 = new User(25, "Vadim");
        User user1 = new User(20, "Maks");
        User user2 = new User(28, "Michail");
        Collections.addAll(list, user0, user1, user2);
        List<User> sortedList = sortUser.sortHash(list);
        StringJoiner sj = new StringJoiner(" : ");
        for (User user : sortedList) {
            sj.add(user.toString());
        }
        String result = sj.toString();
        String expected = new StringJoiner(" : ").add(user2.toString()).add(user1.toString()).add(user0.toString()).toString();
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenSortListByNameLengthThenGetSortedList() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        User user0 = new User(25, "Vadim");
        User user1 = new User(20, "Maks");
        User user2 = new User(28, "Michail");
        Collections.addAll(list, user0, user1, user2);
        List<User> sortedList = sortUser.sortLength(list);
        StringJoiner sj = new StringJoiner(" : ");
        for (User user : sortedList) {
            sj.add(user.toString());
        }
        String result = sj.toString();
        String expected = new StringJoiner(" : ").add(user1.toString()).add(user0.toString()).add(user2.toString()).toString();
        assertThat(result, is(expected));
    }
}
