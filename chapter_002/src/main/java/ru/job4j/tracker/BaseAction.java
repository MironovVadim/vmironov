/**
 * Abstract class BaseAction.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

/**
 * Class for realise method info() with new constructor.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Text of action.
     */
    protected String name;
    /**
     * number of action.
     */
    protected int key;

    /**
     * Constructor.
     * @param name - text of action
     * @param key - number of action
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public String info() {
            return String.format("%s. ", this.key, this.name);
    }
}
