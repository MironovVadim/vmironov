/**
 * Test for class Teacher.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class TrackerTest {
    /**
     * Test add(Item item) method.
     */
    @Test
    public void whenAddItemThenGetThisItem() {
        Tracker tracker = new Tracker();
        Item expected = new Item("SomeName", "someDesc");
        Item result = tracker.add(expected);
        assertThat(result, is(expected));
    }

    /**
     *  Test update() method.
     */
    @Test
    public void whenUpdateItem() {
        Tracker tracker = new Tracker();
        Item itemForUpdate = new Item("someName", "someDesc");
        Item updatedItem = new Item("updatedName", "updatedDesc");
        updatedItem.setId(itemForUpdate.getId());
        tracker.add(itemForUpdate);
        tracker.update(updatedItem);
        Item result = tracker.findById(itemForUpdate.getId());
        Item expected = updatedItem;
        assertThat(result, is(expected));
    }

    /**
     * Test delete() method.
     */
    @Test
    public void whenDeleteItemThenGetNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("someName", "someDesc");
        tracker.add(item);
        tracker.delete(item);
        Item result = tracker.findById(item.getId());
        Item expected = null;
        assertThat(result, is(expected));
    }
    /**
     * Test findAll() method.
     */
    @Test
    public void whenUseMethodThenMassifWithoutNullElements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("SomeName1", "SomeDesc1");
        Item item2 = new Item("SomeName2", "SomeDesc2");
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        Item[] expected = new Item[]{item1, item2};
        assertThat(result, is(expected));
    }
    /**
     * Test findByName(String key) method.
     */
    @Test
    public void whenSearchSomeItemByNameThenGetMassifWithTwoItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("SomeItem", "SomeDesc");
        Item item2 = new Item("SomeItem", "SomeDescToo");
        Item item3 = new Item("SomeOtherItem", "SomeDesc2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName("SomeItem");
        Item[] expected = new Item[]{item1, item2};
        assertThat(result, is(expected));
    }

    /**
     * Test findById(String id) method.
     */
    @Test
    public void whenSearchByIdThenGetItemWithThisID() {
        Tracker tracker = new Tracker();
        Item item = new Item("SomeItem", "SomeDesc");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Item expected = item;
        assertThat(result, is(expected));
    }

    /**
     * Test findById(String id) method.
     */
    @Test
    public void whenSearchByIdThenGetNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("SomeItem", "SomeDesc");
        tracker.add(item);
        Item result = tracker.findById("SomeId");
        Item expected = null;
        assertThat(result, is(expected));
    }

}
