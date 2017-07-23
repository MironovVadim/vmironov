package ru.job4j.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Menu controller.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuController {
    /**
     * ArrayList with all menu items and paragraphs.
     */
    private List<MenuItem> menuItems = new ArrayList<>();
    /**
     * Symbol for indention.
     */
    private static final String INDENT = "---";

    /**
     * Method add new MenuItem.
     * @param itemName - MenuItem name.
     * @param parentParagraph - parent paragraph of new MenuItem.
     */
    public void addMenuItem(String itemName, int... parentParagraph) {
        try {
            if (0 == parentParagraph.length) {
                int paragraph = this.menuItems.size() + 1;
                MenuItem newMenuItem = new MenuItemImpl(itemName, paragraph);
                this.menuItems.add(newMenuItem);
            } else {
                MenuItem parentOfNewItem = this.getChildOfWithParagraph(parentParagraph);
                parentOfNewItem.addChild(itemName, parentParagraph);
            }
        } catch (MenuItemException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method invoke action of MenuItem bu paragraph.
     * @param paragraph - paragraph of MenuItem.
     */
    public void action(int... paragraph) {
        try {
            MenuItem result = this.getChildOfWithParagraph(paragraph);
            result.action();
        } catch (MenuItemException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print menu.
     */
    public void printMenu() {
        for (MenuItem item : this.menuItems) {
            this.printSpecifyItem(item);
            this.printMenu(item.getChildren());
        }
    }

    /**
     * Method return root MenuItem with.
     * @param paragraph of root MenuItem.
     * @return MenuItem with specified paragraph.
     * @throws MenuItemException if root MenuItem not exist.
     */
    private MenuItem getFirstItemOfMenu(int paragraph) throws MenuItemException {
        MenuItem result = null;
        for (MenuItem item : this.menuItems) {
            if (paragraph == item.getParagraph()[0]) {
                result = item;
                break;
            }
        }
        if (result == null) {
            throw new MenuItemException(Integer.toString(paragraph));
        }
        return result;
    }

    /**
     * Method check existence all parents and MenuItem itself of the specified paragraph.
     * If all items exist then return MenuItem with specified paragraph, else throw MenuItemException.
     * @param paragraph of the wanted MenuItem.
     * @return MenuItem with specified paragraph
     * @throws MenuItemException if some of parents or MenuItem itself not exist.
     */
    private MenuItem getChildOfWithParagraph(int... paragraph) throws MenuItemException {
        MenuItem current = this.getFirstItemOfMenu(paragraph[0]);
        for (int i = 2; i <= paragraph.length; i++) {
            current = current.getChild(Arrays.copyOfRange(paragraph, 0, i));

            if (current == null) {
                StringJoiner paragraphNumber = new StringJoiner(".");
                for (int j = 0; j < i; j++) {
                    paragraphNumber.add(Integer.toString(paragraph[j]));
                }
                throw new MenuItemException(paragraphNumber.toString());
            }
        }
        return current;
    }

    /**
     * Method prints specified item info.
     * @param item - specified MenuItem object.
     */
    private void printSpecifyItem(MenuItem item) {
        StringBuilder indention = new StringBuilder();
        int[] paragraph = item.getParagraph();
        for (int i = 1; i < paragraph.length; i++) {
            indention.append(INDENT);
        }
        if (!indention.toString().isEmpty()) {
            indention.append(" ");
        }
        StringJoiner stringParagraph = new StringJoiner(".");
        for (int i = 0; i < paragraph.length; i++) {
            stringParagraph.add(Integer.toString(paragraph[i]));
        }
        System.out.println(String.format("%s%s. %s", indention.toString(), stringParagraph.toString(), item.getName()));
    }

    /**
     * Method prints every MenuItem.
     * @param items - children of some MenuItem parent.
     */
    private void printMenu(List<MenuItem> items) {
        for (MenuItem item : items) {
            this.printSpecifyItem(item);
            this.printMenu(item.getChildren());
        }
    }
}