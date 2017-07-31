/**
 * Class StubUI - UI for tests.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.tracker;

import ru.tracker.exception.MenuOutException;

/**
 * StubInput class.
 */
public class StubInput implements Input {

    /**
     * Massif of command and other strings.
     */
    private String[] answers;

    /**
     * Index of answers.
     */

    private int index = 0;

    /**
     * Constructor.
     * @param answers - answers of command and other strings
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Method for printing param and returning user input.
     * @param question - String for printing in console
     * @return String - user input
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        if (index >= answers.length) {
            return "6";
        }
        return answers[index++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of ru.job4j.menu range");
        }
    }
}
