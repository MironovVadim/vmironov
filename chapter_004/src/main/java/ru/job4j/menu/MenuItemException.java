package ru.job4j.menu;

/**
 * MenuItemException.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuItemException extends Exception {
    /**
     * Default constructor.
     * @param paragraph - String representation of the nonexistent MenuItem paragraph.
     */
    public MenuItemException(String paragraph) {
        super(String.format("MenuItem %s. is not exist.", paragraph));
    }
}
