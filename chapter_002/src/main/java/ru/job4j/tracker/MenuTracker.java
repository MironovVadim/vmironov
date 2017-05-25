/**
 * Classes as commands to manage a Tracker class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

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
    private UserAction[] actions = new UserAction[7];

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
            actions[key].execute(input, tracker);
    }

    /**
     * Method that fill actions[].
     */
    private void fillActions() {
        actions[0] = this.new AddAction("Add new Item", 0);
        actions[1] = new MenuTracker.ShowAllAction("Show all items", 1);
        actions[2] = this.new EditAction("Edit item", 2);
        actions[3] = new DeleteAction("Delete item", 3);
        actions[4] = this.new FindByIdAction("Find item by id", 4);
        actions[5] = this.new FindByNameAction("Find items by name", 5);
        actions[6] = this.new ExitAction("Exit program", 6);
    }

    /**
     * Create massif of of command numbers.
     * @return command massif
     */
    public int[] getRange() {
        int[] range = new int[actions.length];
        for (int i = 0; i < range.length; i++) {
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
         * @param name - test of action
         * @param key - number of action
         */
        private AddAction(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
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
         * @param name - test of action
         * @param key - number of action
         */
        private ShowAllAction(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.findAll().length != 0) {
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
         * @param name - test of action
         * @param key - number of action
         */
        private EditAction(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
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
         * @param name - test of action
         * @param key - number of action
         */
        private FindByIdAction(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
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
         * @param name - test of action
         * @param key - number of action
         */
        private FindByNameAction(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки: ");
            Item[] result = tracker.findByName(name);
            if (result.length != 0) {
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
         * @param name - test of action
         * @param key - number of action
         */
        private ExitAction(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
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
     * @param name - test of action
     * @param key - number of action
     */
    public DeleteAction(String name, int key) {
        super(name, key);
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки, которую хотите удалить: ");
        Item item = new Item(null, null);
        item.setId(id);
        tracker.delete(item);
    }
}