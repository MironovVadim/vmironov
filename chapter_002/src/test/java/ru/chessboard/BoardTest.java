
package ru.chessboard;

import org.junit.Test;
import ru.chessboard.exception.FigureNotFoundException;
import ru.chessboard.exception.ImpossibleMoveException;
import ru.chessboard.exception.OccupiedWayException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class BoardTest {
    /**
     * Test method.
     */
    @Test
    public void whenMoveFigureThenGetTrue() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(3, 3))};
        Board board = new Board(figures);
        boolean result = false;
        try {
            result = board.move(new Cell(3, 3), new Cell(5, 5));
        } catch (ImpossibleMoveException ime) {
            System.out.print(ime.getMessage());
        } catch (OccupiedWayException owe) {
            System.out.print(owe.getMessage());
        } catch (FigureNotFoundException fne) {
            System.out.print(fne.getMessage());
        }
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenMoveFigureThenGetImpossibleMoveExceptionMessage() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(3, 3))};
        Board board = new Board(figures);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            board.move(new Cell(3, 3), new Cell(7, 2));
        } catch (ImpossibleMoveException ime) {
            System.out.print(ime.getMessage());
        } catch (OccupiedWayException owe) {
            System.out.print(owe.getMessage());
        } catch (FigureNotFoundException fne) {
            System.out.print(fne.getMessage());
        }
        String expected = "Неправильный ход слоном.";
        assertThat(baos.toString(), is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenMoveFigureThenGetOccupiedWayExceptionMessage() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(3, 3)), new Elephant(new Cell(4, 4))};
        Board board = new Board(figures);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            board.move(new Cell(3, 3), new Cell(5, 5));
        } catch (ImpossibleMoveException ime) {
            System.out.print(ime.getMessage());
        } catch (OccupiedWayException owe) {
            System.out.print(owe.getMessage());
        } catch (FigureNotFoundException fne) {
            System.out.print(fne.getMessage());
        }
        String expected = "Перемещение невозможно изза фигур на пути.";
        assertThat(baos.toString(), is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenMoveFigureThenGetFigureNotFoundExceptionMessage() {
        Figure[] figures = new Figure[]{new Elephant(new Cell(3, 3))};
        Board board = new Board(figures);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            board.move(new Cell(2, 2), new Cell(5, 5));
        } catch (ImpossibleMoveException ime) {
            System.out.print(ime.getMessage());
        } catch (OccupiedWayException owe) {
            System.out.print(owe.getMessage());
        } catch (FigureNotFoundException fne) {
            System.out.print(fne.getMessage());
        }
        String expected = "Ячейка с координатами x = 2, y = 2 пуста.";
        assertThat(baos.toString(), is(expected));
    }
}
