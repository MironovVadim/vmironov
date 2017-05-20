/**
 * Class Tracker - wrapper of Item[] massif.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Class Tracker.
 */
public class Tracker {
    /**
     * massif of Item elements.
     */
    private Item[] items = new Item[100];
    /**
     * index of first null element in items[].
     */
    private int index = 0;

    /**
     * Adding new Item element.
     *
     * @param item - Item element to add in items[]
     * @return Item - added element
     */
    public Item add(Item item) {
        if (item != null && index < items.length) {
            items[index++] = item;
        }
        return item;
    }

    /**
     *
     * Update item by item.getId().
     *
     * @param item - item with update id
     */
    public void update(Item item) {
        for (int i = 0; i < index; i++) {
            if (items[i].getId().equals(item.getId())) {
                items[i] = item;
                return;
            }
        }
    }

    /**
     * Deleting item and offset elements to left.
     *
     * @param item - item for deleting
     */
    public void delete(Item item) {
        for (int i = 0; i < index; i++) {
            if (items[i].getId().equals(item.getId())) {
                for (int j = i; j < index - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--index] = null;
            }
        }
    }

    /**
     * Searching all items in items without null items.
     *
     * @return all not null items from items[]
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, index);
    }

    /**
     * Searching all items that equals key.
     *
     * @param key - name of search items
     * @return all found items with name that equals key
     */
    public Item[] findByName(String key) {
        Item[] itemMassif = new Item[items.length];
        int indexOfItemMassif = 0;
        for (int i = 0; i < index; i++) {
            if (items[i].getName().equals(key)) {
                itemMassif[indexOfItemMassif++] = items[i];
            }
        }
        return Arrays.copyOf(itemMassif, indexOfItemMassif);
    }

    /**
     * Searching item by id.
     *
     * @param id - id of search item
     * @return found item with id
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < index; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
}
