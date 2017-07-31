/**
 * Classes as commands to manage a Tracker class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with inner classes as commands.
 */
public class MenuTracker {
    /**
     * Class for reading user input.
     */
    private Input input;
    /**
     * Wrapper class of Item[].
     */
    private Tracker tracker;
    /**
     * All commands.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Constructor.
     * @param input - class for reading user input
     * @param tracker - wrapper class of Item[]
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        fillActions();
    }

    /**
     * Execute operation with key.
     * @param key - number of operation
     */
    public void select(int key) {
            actions.get(key).execute(input, tracker);
    }

    /**
     * Method that fill actions.
     */
    private void fillActions() {
        actions.add(this.new AddAction("Add new Item", 0));
        actions.add(new MenuTracker.ShowAllAction("Show all items", 1));
        actions.add(this.new EditAction("Edit item", 2));
        actions.add(new DeleteAction("Delete item", 3));
        actions.add(this.new FindByIdAction("Find item by id", 4));
        actions.add(this.new FindByNameAction("Find items by name", 5));
        actions.add(this.new ExitAction("Exit program", 6));
    }

    /**
     * Create list of command numbers.
     * @return command massif
     */
    public int[] getRange() {
        int[] range = new int[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            range[i] = i;
        }
        return range;
    }

    /**
     * Show all commands.
     */
    public void showActions() {
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Class with add command.
     */
    private class AddAction extends BaseAction {
        /**
         * Constructor.
         * @param name - testtask of action
         * @param key - number of action
         */
        private AddAction(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя пользователя: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Заявка успешно добавлена");
        }
    }

    /**
     * Class with show all command.
     */
    private static class ShowAllAction extends BaseAction {
        /**
         * Constructor.
         * @param name - testtask of action
         * @param key - number of action
         */
        private ShowAllAction(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.findAll().size() != 0) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Список заявок пуст.");
            }
        }
    }

    /**
     * Class with edit command.
     */
    private class EditAction extends BaseAction {
        /**
         * Constructor.
         * @param name - testtask of action
         * @param key - number of action
         */
        private EditAction(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую хотите обновить: ");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            item.setId(id);
            tracker.update(item);
        }
    }

    /**
     * Class with find by id command.
     */
    private class FindByIdAction extends BaseAction {
        /**
         * Constructor.
         * @param name - testtask of action
         * @param key - number of action
         */
        private FindByIdAction(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            Item result = tracker.findById(id);
            System.out.println(result != null ? result.toString() : "Заявки с заданым id несущетсвует.");
        }
    }

    /**
     * Class with find by name command.
     */
    private class FindByNameAction extends BaseAction {
        /**
         * Constructor.
         * @param name - testtask of action
         * @param key - number of action
         */
        private FindByNameAction(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки: ");
            List<Item> result = tracker.findByName(name);
            if (result.size() != 0) {
                for (Item item : result) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Заявок с заданным именем не найдено.");
            }
        }
    }

    /**
     * Class with exit command.
     */
    private class ExitAction extends BaseAction {
        /**
         * Constructor.
         * @param name - testtask of action
         * @param key - number of action
         */
        private ExitAction(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            return;
        }
    }
}

/**
 * Class with delete command.
 */
class DeleteAction extends BaseAction {
    /**
     * Constructor.
     * @param name - testtask of action
     * @param key - number of action
     */
    DeleteAction(String name, int key) {
        super(name, key);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки, которую хотите удалить: ");
        Item item = new Item(null, null);
        item.setId(id);
        tracker.delete(item);
    }
}