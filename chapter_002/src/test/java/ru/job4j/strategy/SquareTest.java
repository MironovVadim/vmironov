/**
 * Test Square class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class SquareTest {
    /**
     * Test method.
     */
    @Test
    public void whenDrawShapeThenDrawSquare() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Shape shape = new Square();
        new Paint(shape).draw();
        StringBuilder sb = new StringBuilder();
        sb.append("0000" + System.lineSeparator()).append("0  0" + System.lineSeparator()).
                append("0  0" + System.lineSeparator()).append("0  0" + System.lineSeparator()).append("0000");
        assertThat(baos.toString(), is(sb.toString()));
    }
}
