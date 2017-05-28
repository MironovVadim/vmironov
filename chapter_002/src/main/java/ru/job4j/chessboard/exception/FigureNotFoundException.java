/**
 * Exception.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.chessboard.exception;

/**
 * Exception.
 */
public class FigureNotFoundException extends Exception {
    /**
     * Constructor.
     * @param message - message of exception
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
