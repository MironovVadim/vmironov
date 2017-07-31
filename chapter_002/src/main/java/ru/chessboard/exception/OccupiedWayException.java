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
public class OccupiedWayException extends Exception {
    /**
     * Constructor.
     * @param message - message of exception
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
