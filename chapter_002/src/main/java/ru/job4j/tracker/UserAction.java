/**
 * Interface with methods to manage Tracker class.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

/**
 * Interface for all commands with Tracker class.
 */
public interface UserAction {
    /**
     * Return number of operation.
     * @return int - number
     */
    int key();

    /**
     * Execution operation.
     * @param input - interface for read a commands
     * @param tracker - wrapper class with commands to manage Item[]
     */
    void execute(Input input, Tracker tracker);

    /**
     * Info about operation.
     * @return info of operation
     */
    String info();
}