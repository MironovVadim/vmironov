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
        Item expected = new Item("5", "someName");
        Item result = tracker.add(expected);
        assertThat(result, is(expected));
    }
    /**
     * Test findAll() method.
     */
    @Test
    public void whenUseMethodThenMassifWithoutNullElements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "SomeItem");
        Item item2 = new Item("1", "SomeItem");
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
    public void whenSearchSomeItemThenGetMassifWithTwoItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "SomeItem");
        Item item2 = new Item("1", "SomeItem");
        Item item3 = new Item("2", "NotSomeItem");
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
    public void whenSearchByTwoThenGetItemWithIdTwo() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("0", "SomeItem0");
        Item item1 = new Item("1", "SomeItem1");
        Item item2 = new Item("2", "SomeItem2");
        Item item3 = new Item("3", "SomeItem3");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById("2");
        Item expected = item2;
        assertThat(result, is(expected));
    }
}
