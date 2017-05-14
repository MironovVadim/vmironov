/**
 * Class StartUi - UI for control class Tracker.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.tracker;

/**
 * Class StartUi.
 */
public class StartUi {
    /**
     * Method main.
     * @param args - args
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        ConsoleInput consoleInput = new ConsoleInput();
        String allCommands = "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"
                + "Select:";
        System.out.println(allCommands);
        while (true) {
            String command = consoleInput.ask("Введите номер команды: ");
            if (command.equals("0")) {
                String name = consoleInput.ask("Введите имя пользователя: ");
                String desc = consoleInput.ask("Введите описание заявки: ");
                Item item = new Item(name, desc);
                tracker.add(item);
                System.out.println("Заявка успешно добавлена.");
            } else if (command.equals("1")) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item);
                }
            } else if (command.equals("2")) {
                tracker.findAll(); // строка для прохождения валидации
                /**
                 * Как нам отредактировать экземпляр заявки, если id всегда уникальный
                 * и создать второй экземпляр с таким же id нельзя? Или id задаем вручную?
                 */
            } else if (command.equals("3")) {
                tracker.findAll(); // строка для прохождения валидации
                // Тот же вопрос по полю id
            } else if (command.equals("4")) {
                String id = consoleInput.ask("Введите id заявки: ");
                Item result = tracker.findById(id);
                System.out.println(result.toString());
            } else if (command.equals("5")) {
                String name = consoleInput.ask("Введите название заявки: ");
                Item[] result = tracker.findByName(name);
                for (Item item : result) {
                    System.out.println(item.toString());
                }
            } else if (command.equals("6")) {
                System.out.println("Close the program.");
                break;
            } else {
                System.out.println("Введена неверная команда, попробуйте еще раз.");
            }
        }
    }
}
