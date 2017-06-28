/**
 * Test Frog class.
 *
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.frog;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Frog class.
 */
public class FrogTest {
    /**
     * Test findTheWayFrom(int y, int x) method.
     */
    @Test
    public void whenFrogReachedDstCellThenGetTwo() {
        int[][] field = new int[8][8];
        Frog frog = new Frog(field, 6, 7);
        int result = frog.findTheWayFrom(3, 0);
        int expected = 4;
        assertThat(result, is(expected));
    }

    /**
     * Test findTheWayFrom(int y, int x) method.
     */
    @Test
    public void whenFrogDoNotReachedDstCellThenGetMinusOne() {
        int[][] field = new int[6][6];
        Frog frog = new Frog(field, 4, 5);
        int result = frog.findTheWayFrom(0, 5);
        int expected = -1;
        assertThat(result, is(expected));
    }
}
