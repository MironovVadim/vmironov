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
    public void whenSearchSomeItemThenGetMassifWithTwoItems() {
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
    public void whenSearchByTwoThenGetItemWithIdTwo() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("SomeItem0", "SomeDesc");
        Item item1 = new Item("SomeItem1", "SomeDesc");
        Item item2 = new Item("SomeItem2", "SomeDesc");
        Item item3 = new Item("SomeItem3", "SomeDesc");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById("7");
        Item expected = item3;
        assertThat(result, is(expected));
    }
}
