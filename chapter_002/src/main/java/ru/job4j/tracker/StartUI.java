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
     * massif of range of commands.
     */
    private int[] range;
    /**
     * Input of StartUI class.
     */
    private Input input;
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
        menuTracker = new MenuTracker(input, tracker);
        this.range = menuTracker.getRange();
    }

    /**
     * Start program method.
     */
    public void init() {
        int key;
        do {
            menuTracker.showActions();
            key = input.ask("Select: ", range);
            menuTracker.select(key);
        } while (!"6".equals(Integer.toString(key)));
    }
}