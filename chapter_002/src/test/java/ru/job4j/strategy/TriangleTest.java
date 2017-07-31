/**
 * Test Triangle class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.strategy;

import org.junit.Test;
import ru.job4j.strategy.Paint;
import ru.job4j.strategy.Shape;
import ru.job4j.strategy.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class TriangleTest {
    /**
     * Test method.
     */
    @Test
    public void whenDrawShapeThenDrawTriangle() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Shape shape = new Triangle();
        new Paint(shape).draw();
        StringBuilder sb = new StringBuilder();
        sb.append("00000" + System.lineSeparator()).append(" 000 " + System.lineSeparator()).append("  0  ");
        assertThat(baos.toString(), is(sb.toString()));
    }
}
