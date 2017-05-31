package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
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
        List<Integer> list = new ArrayList<>();
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
}
