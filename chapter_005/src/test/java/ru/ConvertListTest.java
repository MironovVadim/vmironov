/**
 * Test ConvertList class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru;

import org.junit.Test;
import ru.job4j.ConvertList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Test class.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertListTest {
    /**
     * Test method.
     */
    @Test
    public void whenConvertArrayThenGetList() {
        ConvertList convertList = new ConvertList();
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = convertList.toList(array);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenConvertListThenGetArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        int[][] result = convertList.toArray(list, 3);
        int[][] expected = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 0}
        };
        assertThat(result, is(expected));
    }
    /**
     * Test method.
     */
    @Test
    public void whenConvertListWithIntMassifThenGetListWithInteger() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3, 4, 5});
        list.add(new int[]{6, 7, 8});
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expected));
    }
}
