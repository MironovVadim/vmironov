/**
 * Class Tracker - wrapper of Item[] massif.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Tracker.
 */
public class Tracker {
    /**
     * List of Item elements.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Adding new Item element.
     *
     * @param item - Item element to add in List<Item>
     * @return Item - added element
     */
    public Item add(Item item) {
        if (item != null) {
            items.add(item);
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
        for (Item itemInItems : items) {
            if (item.getId().equals(itemInItems.getId())) {
                items.add(items.indexOf(itemInItems), item);
                return;
            }
        }
    }

    /**
     * Deleting item from items.
     *
     * @param item - item for deleting
     */
    public void delete(Item item) {
        for (Item itemInItems : items) {
            if (item.getId().equals(itemInItems.getId())) {
                items.remove(itemInItems);
                return;
            }
        }
    }

    /**
     * Retern items.
     *
     * @return items
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Searching all items that equals key.
     *
     * @param key - name of search items
     * @return all found items with name that equals key
     */
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * Searching item by id.
     *
     * @param id - id of search item
     * @return found item with id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (id.equals(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }
}