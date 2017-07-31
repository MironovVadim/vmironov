/**
 * Class ElephantTest.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.chessboard;

import org.junit.Test;
import ru.chessboard.exception.ImpossibleMoveException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class.
 */
public class ElephantTest {
    /**
     * Test Method.
     */
    @Test
    public void whenMoveCellThenGetTwoCells() {
        Figure figure = new Elephant(new Cell(5, 3));
        Cell[] result = null;
        try {
            result = figure.way(new Cell(3, 5));
        } catch (ImpossibleMoveException e) {
            System.out.print(e.getMessage());
        }
        Cell[] expected = new Cell[]{new Cell(4, 4), new Cell(3, 5)};
        assertThat(result, is(expected));
    }
    /**
     * Test Method.
     */
    @Test
    public void whenMoveOnWrongCellThenGetExceptionMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Figure figure = new Elephant(new Cell(3, 3));
        try {
            figure.way(new Cell(4, 5));
        } catch (ImpossibleMoveException e) {
            System.out.print(e.getMessage());
        }
        String result = baos.toString();
        String expected = "Неправильный ход слоном.";
        assertThat(result, is(expected));
    }
}
