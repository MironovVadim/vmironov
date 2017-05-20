/**
 * Test for StartUI class.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class StartUITest {
    /**
     * Test add() method.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        String[] answers = new String[]{"0", "SomeName", "SomeDesc", "6"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(answers[1]));
    }
    /**
     * Test findAll() method.
     */
    @Test
    public void whenAskFindAllMethodThenGetTwoItems() {
        Item item = new Item("SomeName", "SomeDesc");
        Item item1 = new Item("ItemName", "ItemDesk");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        String[] answers = new String[]{"1", "6"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new StartUI(input, tracker).init();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("0. Add new Item").add("1. Show all items").add("2. Edit item").add("3. Delete item");
        stringJoiner.add("4. Find item by Id").add("5. Find items by name").add("6. Exit program").add("Select:");
        stringJoiner.add(item.toString()).add(item1.toString()).add("Close the program.").add("");
        String expected = stringJoiner.toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test update() method.
     */
    @Test
    public void whenUpdateItemThenTrackerHasUpdatedItem() {
        Item itemForUpdate = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(itemForUpdate);
        String[] answers = new String[]{"2", itemForUpdate.getId(), "UpdatedName", "UpdatedDesc", "6"};
        Input input = new StubInput(answers);
        Item expected = new Item(answers[2], answers[3]);
        expected.setId(itemForUpdate.getId());
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(expected));
    }
    /**
     * Test update() method.
     */
    @Test
    public void whenUpdateNonexistentItemThenTrackerHasUnrefinedItem() {
        Item itemForUpdate = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(itemForUpdate);
        String[] answers = new String[]{"2", "NonexistentId", "UpdatedName", "UpdatedDesc", "6"};
        Input input = new StubInput(answers);
        Item expected = itemForUpdate;
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(expected));
    }
    /**
     * Test delete() method.
     */
    @Test
    public void whenDeleteItemThenGetEmptyMassif() {
        Item itemForDel = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(itemForDel);
        String[] answers = new String[]{"3", itemForDel.getId(), "6"};
        Input input = new StubInput(answers);
        int expected = 0;
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(expected));
    }
    /**
     * Test delete() method.
     */
    @Test
    public void whenDeleteNonexistentItemThenGetMassifWithOneItem() {
        Item itemForDel = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(itemForDel);
        String[] answers = new String[]{"3", "NonexistentId", "6"};
        Input input = new StubInput(answers);
        Item expected = itemForDel;
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(expected));
    }
    /**
     * Test findById() method.
     */
    @Test
    public void whenSearchByNonexistentIdThenGetNoItems() {
        Item item = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = new String[]{"4", "NonexistentId", "6"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new StartUI(input, tracker).init();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("0. Add new Item").add("1. Show all items").add("2. Edit item").add("3. Delete item");
        stringJoiner.add("4. Find item by Id").add("5. Find items by name").add("6. Exit program").add("Select:");
        stringJoiner.add("Close the program.").add("");
        String expected = stringJoiner.toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test findById() method.
     */
    @Test
    public void whenSearchByIdThenGetItemWithThisId() {
        Item item = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = new String[]{"4", item.getId(), "6"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new StartUI(input, tracker).init();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("0. Add new Item").add("1. Show all items").add("2. Edit item").add("3. Delete item");
        stringJoiner.add("4. Find item by Id").add("5. Find items by name").add("6. Exit program").add("Select:");
        stringJoiner.add(item.toString()).add("Close the program.").add("");
        String expected = stringJoiner.toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test findByName() method.
     */
    @Test
    public void whenSearchByNameThenGetTwoItems() {
        Item item = new Item("SomeName", "SomeDesc");
        Item item1 = new Item("SomeName", "Description");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        String[] answers = new String[]{"5", item.getName(), "6"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new StartUI(input, tracker).init();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("0. Add new Item").add("1. Show all items").add("2. Edit item").add("3. Delete item");
        stringJoiner.add("4. Find item by Id").add("5. Find items by name").add("6. Exit program").add("Select:");
        stringJoiner.add(item.toString()).add(item1.toString()).add("Close the program.").add("");
        String expected = stringJoiner.toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test findByName() method.
     */
    @Test
    public void whenSearchByNameThenGetNoItems() {
        Item item = new Item("SomeName", "SomeDesc");
        Item item1 = new Item("SomeName", "Description");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        String[] answers = new String[]{"5", "NoName", "6"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new StartUI(input, tracker).init();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("0. Add new Item").add("1. Show all items").add("2. Edit item").add("3. Delete item");
        stringJoiner.add("4. Find item by Id").add("5. Find items by name").add("6. Exit program").add("Select:");
        stringJoiner.add("Close the program.").add("");
        String expected = stringJoiner.toString();
        assertThat(baos.toString(), is(expected));
    }
}