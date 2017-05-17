/**
 * Class StartUI - UI for control class Tracker.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.tracker;

import java.util.StringJoiner;

/**
 * Class StartUI.
 */
public class StartUI {
    /**
     * Add command.
     */
    private static final String ADD = "0";
    /**
     * Show all command.
     * Show all items without null elements.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Update command.
     */
    private static final String UPDATE = "2";
    /**
     * Delete command.
     */
    private static final String DELETE = "3";
    /**
     * Find by id command.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Find by name command.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Exit command.
     */
    private static final String EXIT = "6";
    /**
     * Input of StartUI class.
     */
    private Input input;
    /**
     * Tracker object.
     */
    private Tracker tracker;

    /**
     * Constructor.
     * @param input - set input
     * @param tracker - tracker object
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method main.
     * @param args - args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }

    /**
     * Start program method.
     */
    public void init() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("0. Add new Item").add("1. Show all items").add("2. Edit item").add("3. Delete item");
        stringJoiner.add("4. Find item by Id").add("5. Find items by name").add("6. Exit program").add("Select:");
        System.out.println(stringJoiner.toString());
        while (true) {
            String command = input.ask("Введите номер команды: ");
            if (command.equals(ADD)) {
                String name = input.ask("Введите имя пользователя: ");
                String desc = input.ask("Введите описание заявки: ");
                Item item = new Item(name, desc);
                tracker.add(item);
                System.out.println("Заявка успешно добавлена.");
            } else if (command.equals(SHOW_ALL)) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item);
                }
            } else if (command.equals(UPDATE)) {
                String id = input.ask("Введите id заявки, которую хотите обновить: ");
                String name = input.ask("Введите имя заявки: ");
                String desc = input.ask("Введите описание заявки: ");
                Item item = new Item(name, desc);
                item.setId(id);
                tracker.update(item);
            } else if (command.equals(DELETE)) {
                String id = input.ask("Введите id заявки, которую хотите удалить: ");
                Item item = new Item(null, null);
                item.setId(id);
                tracker.delete(item);
            } else if (command.equals(FIND_BY_ID)) {
                String id = input.ask("Введите id заявки: ");
                Item result = tracker.findById(id);
                System.out.println(result.toString());
            } else if (command.equals(FIND_BY_NAME)) {
                String name = input.ask("Введите название заявки: ");
                Item[] result = tracker.findByName(name);
                for (Item item : result) {
                    System.out.println(item.toString());
                }
            } else if (command.equals(EXIT)) {
                System.out.println("Close the program.");
                break;
            } else {
                System.out.println("Введена неверная команда, попробуйте еще раз.");
            }
        }
    }
}
