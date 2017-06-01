/**
 * Cell of chess board.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.chessboard;

/**
 * Class Cell.
 */
public class Cell {
    /**
     * abscissa on chess board.
     */
    private int x;
    /**
     *
     ordinate on chess board.
     */
    private int y;

    /**
     * Constructor.
     * @param x - abscissa
     * @param y - ordinate
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter.
     * @param x - abscissa
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Getter.
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * Setter.
     * @param y - ordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (x != cell.x) {
            return false;
        }
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
