/**
 * Interface Input.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

/**
 * Interface Input.
 */
public interface Input {
    /**
     * Method for printing param and returning user input.
     * @param question - String for printing in console
     * @return String - user input
     */
    String ask(String question);

    /**
     * ask() mtethod with testtask user input.
     * @param question - String for printing in console
     * @param range - range of commands
     * @return number of command
     */
    int ask(String question, int[] range);
}
