/**
 * Class StartUI - UI for control class Tracker.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

/**
 * StubInput class.
 */
public class StubInput implements Input {
    /**
     * Method for printing param and returning user input.
     * @param question - String for printing in console
     * @return String - user input
     */
    @Override
    public String ask(String question) {
        return null;
    }
}
