package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Teacher.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class EngineerTest {
    /**
     * Test method.
     */
    @Test
    public void whenSomeStringThenFileWithThisString() {
        Engineer engineer = new Engineer("Сергей", "Булыжников", "Кораблестроитель", 3);
        String result = "План управления балластом";
        String expected = engineer.makeADocument(result).getName();
        assertThat(result, is(expected));
    }
    /**
     * Test method.
     */
    @Test
    public void whenNegativeTwoThenTwo() {
        Engineer engineer = new Engineer("Сергей", "Булыжников", "Кораблестроитель", -2);
        int result = 2;
        int expected = engineer.getCategory();
        assertThat(result, is(expected));
    }
}
