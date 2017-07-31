/**
 * Test Class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.tracker;

import ru.tracker.exception.MenuOutException;

/**
 * Test Class.
 */
public class StubValidateInput extends StubInput {
    /**
     * Constructor.
     * @param answers - user answers
     */
    public StubValidateInput(String[] answers) {
        super(answers);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please enter validate data.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter the number.");
            }
        } while (invalid);
        return value;
    }
}
