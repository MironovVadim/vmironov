/**
 * Class ValidInput with one overriding method ask().
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

import ru.job4j.tracker.exception.MenuOutException;

/**
 * ValidateInput class.
 */
public class ValidateInput extends ConsoleInput {

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
