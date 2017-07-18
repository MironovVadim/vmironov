package ru.job4j.menu;

/**
 * Menu item interface.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface MenuItem {
    /**
     * Name getter.
     * @return name.
     */
    String getName();

    /**
     * Action of menu item.
     */
    void action();
}
