package ru.job4j.menu;

import java.util.List;

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
     * Getter of MenuItem paragraph.
     * @return massif with numbers of paragraph
     */
    int[] getParagraph();

    /**
     * Method returns list with child paragraphs.
     * @return all children of current MenuItem object.
     */
    List<MenuItem> getChildren();

    /**
     * Method returns child with specified paragraph.
     * @param paragraph of wanted MenuItem.
     * @return MenuItem with specified paragraph.
     */
    MenuItem getChild(int[] paragraph);

    /**
     * Method adds new MenuItem.
     * @param itemName - name of the new MenuItem.
     * @param parentParagraph - paragraph of the new MenuItem.
     */
    void addChild(String itemName, int[] parentParagraph);

    /**
     * Action of menu item.
     */
    void action();
}
