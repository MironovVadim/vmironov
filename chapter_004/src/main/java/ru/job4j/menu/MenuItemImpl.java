package ru.job4j.menu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Menu item implementation.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuItemImpl implements MenuItem {
    /**
     * massif with numbers of MenuItem paragraph.
     */
    private int[] paragraph;
    /**
     * Name of menu item.
     */
    private String name;
    /**
     * List with children paragraphs.
     */
    private List<MenuItem> children = new ArrayList<>();

    /**
     * Default constructor.
     * @param name - name of menu item.
     * @param paragraph - new paragraph.
     */
    public MenuItemImpl(String name, int... paragraph) {
        this.name = name;
        this.paragraph = paragraph;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int[] getParagraph() {
        return this.paragraph;
    }

    @Override
    public List<MenuItem> getChildren() {
        return this.children;
    }

    @Override
    public MenuItem getChild(int[] paragraph) {
        MenuItem result = null;
        for (MenuItem item : this.children) {
            if (Arrays.equals(paragraph, item.getParagraph())) {
                result = item;
                break;
            }
        }
        return result;
    }

    @Override
    public void addChild(String itemName, int[] parentParagraph) {
        int[] newParagraph = Arrays.copyOf(parentParagraph, parentParagraph.length + 1);
        int lastNumberOfParagraph = this.children.size() + 1;
        newParagraph[newParagraph.length - 1] = lastNumberOfParagraph;
        MenuItem newMenuItem = new MenuItemImpl(itemName, newParagraph);
        this.children.add(newMenuItem);
    }

    @Override
    public void action() {
        System.out.println(String.format("%s: action.", this.name));
    }
}
