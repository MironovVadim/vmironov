/**
 * Chess board class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.chessboard;

import ru.job4j.chessboard.exception.FigureNotFoundException;
import ru.job4j.chessboard.exception.ImpossibleMoveException;
import ru.job4j.chessboard.exception.OccupiedWayException;

/**
 * Chess board with all figures on it.
 */
public class Board {
    /**
     * All figures on chess board.
     */
    private Figure[] figures;

    /**
     * Constructor.
     * @param figures - all figures on chess board
     */
    public Board(Figure[] figures) {
        this.figures = figures;
    }

    /**
     * Method for moving a figure.
     * @param source - start of moving
     * @param dest - end of moving
     * @return boolean - if figure was moved
     * @throws ImpossibleMoveException if cannot move figure
     * @throws OccupiedWayException if any other figures of way
     * @throws FigureNotFoundException if no figure on cell
     */
    public boolean move(Cell source, Cell dest)  throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure sourceFigure = this.getFigureWithSpecifiedCell(source);
        if (sourceFigure == null) {
            throw new FigureNotFoundException(String.format("Ячейка с координатами x = %s, y = %s пуста.", source.getX(), source.getY()));
        }
        Cell[] way = sourceFigure.way(dest);
        for (Cell cell : way) {
            if (this.getFigureWithSpecifiedCell(cell) != null) {
                throw new OccupiedWayException("Перемещение невозможно изза фигур на пути.");
            }
        }
        sourceFigure.clone(dest);
        return true;
    }

    /**
     * Method for searching a figure with @param.
     * @param cell - cell with x, y coordinates
     * @return Figure with @param cell.
     */
    private Figure getFigureWithSpecifiedCell(Cell cell) {
        Figure figureWithCell = null;
        for (Figure figure : this.figures) {
            if (cell.equals(figure.getPosition())) {
                figureWithCell = figure;
                break;
            }
        }
        return figureWithCell;
    }
}
