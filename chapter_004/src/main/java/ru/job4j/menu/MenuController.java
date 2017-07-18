package ru.job4j.menu;

import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.Map;

/**
 * Menu controller.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuController {
    /**
     * TreeMap with all menu items and paragraphs. map Sorted by paragraphs.
     */
    private SortedMap<int[], MenuItem> menuItems = new TreeMap<>((o1, o2) -> {
        int result = 0;
        for (int i = 0; i < o1.length && i < o2.length; i++) {
            result = Integer.compare(o1[i], o2[i]);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result += Integer.compare(o1.length, o2.length);
        }
        return result;
    });

    /**
     * Method add new MenuItem.
     * @param newMenuItem - MenuItem.
     * @param paragraph - paragraph of MenuItem.
     */
    public void addMenuItem(MenuItem newMenuItem, int... paragraph) {
        this.menuItems.put(paragraph, newMenuItem);
    }

    /**
     * Method print menu.
     */
    public void printMenu() {
        for (Map.Entry<int[], MenuItem> it : menuItems.entrySet()) {
            StringBuilder sb = new StringBuilder();
            int[] paragraph = it.getKey();
            for (int i = 0; i < paragraph.length - 1; i++) {
                sb.append("---");
            }
            if (!sb.toString().isEmpty()) {
                sb.append(" ");
            }
            StringJoiner sj = new StringJoiner(".");
            for (int number : paragraph) {
                sj.add(Integer.toString(number));
            }
            System.out.println(String.format("%s%s %s", sb.toString(), sj.toString(), it.getValue().getName()));
        }
    }

    /**
     * Method invoke action of MenuItem bu paragraph.
     * @param paragraph - paragraph of MenuItem.
     */
    public void action(int... paragraph) {
        MenuItem item = this.menuItems.get(paragraph);
        if (item == null) {
            StringJoiner sj = new StringJoiner(".");
            for (int number : paragraph) {
                sj.add(Integer.toString(number));
            }
            System.out.println(String.format("%s paragraph does not exist.", sj.toString()));
        } else {
            item.action();
        }
    }
}
