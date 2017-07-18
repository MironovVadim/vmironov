package ru.job4j.menu;


/**
 * Menu item implementation.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuItemImpl implements MenuItem {
    /**
     * Name of menu item.
     */
    private String name;

    /**
     * Default constructor.
     * @param name - name of menu item.
     */
    public MenuItemImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action() {
        System.out.println(String.format("%s: action.", this.name));
    }
}
