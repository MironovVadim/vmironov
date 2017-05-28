/**
 * Chess figure.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.chessboard;

import ru.job4j.chessboard.exception.ImpossibleMoveException;

/**
 * Class Elephant.
 */
public class Elephant extends Figure {
    /**
     * Constructor.
     * @param position - figure position
     */
    public Elephant(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int xLength = Math.abs(this.position.getX() - dist.getX());
        int yLength = Math.abs(this.position.getY() - dist.getY());
        if (xLength != yLength) {
            throw new ImpossibleMoveException("Неправильный ход слоном.");
        }
        int xIncrement = this.position.getX() < dist.getX() ? 1 : -1;
        int yIncrement = this.position.getY() < dist.getY() ? 1 : -1;
        Cell[] result = new Cell[xLength];
        int currentX = this.position.getX();
        int currentY = this.position.getY();
        for (int i = 0; i < result.length; i++) {
            currentX += xIncrement;
            currentY += yIncrement;
            result[i] = new Cell(currentX, currentY);
        }
        return result;
    }
}
