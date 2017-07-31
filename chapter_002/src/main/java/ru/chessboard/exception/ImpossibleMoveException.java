/**
 * Exception.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.chessboard.exception;

/**
 * Exception.
 */
public class ImpossibleMoveException extends Exception {
    /**
     * Constructor.
     * @param message - message of exception
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
