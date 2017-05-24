/**
 * MenuOutException
 *
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker.exception;

/**
 * Exception.
 */
public class MenuOutException extends RuntimeException {
    /**
     * Exception for number not in range of massif.
     * @param message - text of exception
     */
    public MenuOutException(String message) {
        super(message);
    }
}
