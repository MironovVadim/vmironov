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
        actions[0] = this.new AddAction();
        actions[1] = new MenuTracker.ShowAllAction();
        actions[2] = this.new EditAction();
        actions[3] = new DeleteAction();
        actions[4] = this.new FindByIdAction();
        actions[5] = this.new FindByNameAction();
        actions[6] = this.new ExitAction();
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
    private class AddAction implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя пользователя: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Заявка успешно добавлена");
        }

        @Override
        public String info() {
            return String.format("%s. Add new Item", this.key());
        }
    }

    /**
     * Class with show all command.
     */
    private static class ShowAllAction implements UserAction {
        @Override
        public int key() {
            return 1;
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

        @Override
        public String info() {
            return String.format("%s. Show all items", this.key());
        }
    }

    /**
     * Class with edit command.
     */
    private class EditAction implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. Edit item", this.key());
        }
    }

    /**
     * Class with find by id command.
     */
    private class FindByIdAction implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            Item result = tracker.findById(id);
            System.out.println(result != null ? result.toString() : "Заявки с заданым id несущетсвует.");
        }

        @Override
        public String info() {
            return String.format("%s. Find item by id", this.key());
        }
    }

    /**
     * Class with find by name command.
     */
    private class FindByNameAction implements UserAction {
        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. Find items by name", this.key());
        }
    }

    /**
     * Class with exit command.
     */
    private class ExitAction implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            return;
        }

        @Override
        public String info() {
            return String.format("%s. Exit program", this.key());
        }
    }
}

/**
 * Class with delete command.
 */
class DeleteAction implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки, которую хотите удалить: ");
        Item item = new Item(null, null);
        item.setId(id);
        tracker.delete(item);
    }

    @Override
    public String info() {
        return String.format("%s. Delete item", this.key());
    }
}