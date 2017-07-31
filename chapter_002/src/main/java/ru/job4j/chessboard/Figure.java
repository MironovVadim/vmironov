/**
 * Figure class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.chessboard;

import ru.job4j.chessboard.exception.ImpossibleMoveException;

/**
 * Abstract class Figure.
 */
public abstract class Figure {
    /**
     * Position on chess board.
     */
    private final Cell position;

    /**
     * Constructor.
     * @param position - position with abscissa and ordinate.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Method that returns way of moving chess figure.
     * @param dist - destination
     * @return - way as massif of cells
     * @throws ImpossibleMoveException if cannot move a figure
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * position getter.
     * @return position.
     */
    public Cell getPosition() {
        return position;
    }

    /**
     * Method change a cell if figure.
     * @param dest - new cell
     * @return figure with new cell
     */
    public Figure clone(Cell dest) {
        this.position.setX(dest.getX());
        this.position.setY(dest.getY());
        return this;
    }
}
