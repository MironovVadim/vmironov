/**
 * Test UserConvert class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class.
 */
public class UserConvertTest {
    /**
     * Test method.
     */
    @Test
    public void whenConvertListWithUsersThenGetHashMapWithUserIdAndUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(15, "Vadim", "Vladivostok"));
        list.add(new User(23, "Maks", "Piter"));
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(15, new User(15, "Vadim", "Vladivostok"));
        expected.put(23, new User(23, "Maks", "Piter"));
        assertThat(result, is(expected));
    }
}
