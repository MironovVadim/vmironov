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
}
