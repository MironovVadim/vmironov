/**
 * Class ValidInput with one overriding method ask().
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.tracker;

import ru.tracker.exception.MenuOutException;

import java.util.Scanner;

/**
 * ValidateInput class.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Default constuctor.
     * @param scanner - new scanner.
     */
    public ValidateInput(Scanner scanner) {
        super(scanner);
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
