/**
 * Class StartUI - UI for control class Tracker.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.tracker;

/**
 * Class StartUI.
 */
public class StartUI {
    /**
     * Input of StartUI class.
     */
    private Input input;
    /**
     * Tracker object.
     */
    private Tracker tracker;
    /**
     * Class for managing Tracker class.
     */
    private MenuTracker menuTracker;
    /**
     * Constructor.
     * @param input - set input
     * @param tracker - tracker object
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        menuTracker = new MenuTracker(input, tracker);
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
        int key;
        do {
            menuTracker.showActions();
            key = Integer.valueOf(input.ask("Select: "));
            menuTracker.select(key);
        } while (!"6".equals(Integer.toString(key)));
    }
}