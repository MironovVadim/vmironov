/**
 * Test MenuTracker class.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class MenuTrackerTest {
    /**
     * Test AddAction class.
     */
    @Test
    public void whenExecuteAddActionThenTrackerWithOneItem() {
        Tracker tracker = new Tracker();
        String[] answers = new String[]{"SomeName", "SomeDesk"};
        Input input = new StubInput(answers);
        new MenuTracker(input, tracker).select(0);
        int expected = 1;
        assertThat(tracker.findAll().size(), is(expected));
    }
    /**
     * Test showAllAction class.
     */
    @Test
    public void whenExecuteShowAllActionThenShowTwoItems() {
        Item item = new Item("SomeName", "SomeDesc");
        Item item1 = new Item("Name", "Desc");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        Input input = new StubInput(null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new MenuTracker(input, tracker).select(1);
        String expected = new StringJoiner(System.lineSeparator()).add(item.toString()).add(item1.toString()).add("").toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test EditAction class.
     */
    @Test
    public void whenExecuteEditActionThenGetEditedItem() {
        Item itemForEdit = new Item("SomeName", "SomeDesc");
        Item itemAfterEdit = new Item("UpdatedName", "UpdatedDesc");
        itemAfterEdit.setId(itemForEdit.getId());
        Tracker tracker = new Tracker();
        tracker.add(itemForEdit);
        String[] answers = new String[]{itemForEdit.getId(), itemAfterEdit.getName(), itemAfterEdit.getDesc()};
        Input input = new StubInput(answers);
        new MenuTracker(input, tracker).select(2);
        assertThat(tracker.findAll().get(0), is(itemAfterEdit));
    }
    /**
     * Test EditAction class.
     */
    @Test
    public void whenExecuteEditActionThenGetNotEditedItem() {
        Item itemForEdit = new Item("SomeName", "SomeDesc");
        Item itemUfterEdit = new Item("UpdatedName", "UpdatedDesc");
        itemUfterEdit.setId(itemForEdit.getId());
        Tracker tracker = new Tracker();
        tracker.add(itemForEdit);
        String[] answers = new String[]{"NoSuchId", itemUfterEdit.getName(), itemUfterEdit.getDesc()};
        Input input = new StubInput(answers);
        new MenuTracker(input, tracker).select(2);
        assertThat(tracker.findAll().get(0), is(itemForEdit));
    }
    /**
     * Test DeleteAction class.
     */
    @Test
    public void whenExecuteDeleteActionThenGetEmptyMassifOfItems() {
        Item itemForDelete = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(itemForDelete);
        String[] answers = new String[]{itemForDelete.getId()};
        Input input = new StubInput(answers);
        new MenuTracker(input, tracker).select(3);
        int expected = 0;
        assertThat(tracker.findAll().size(), is(expected));
    }
    /**
     * Test DeleteAction class.
     */
    @Test
    public void whenExecuteDeleteActionThenGetMassifWithOneItem() {
        Item itemForDelete = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(itemForDelete);
        String[] answers = new String[]{"NoSuchId"};
        Input input = new StubInput(answers);
        new MenuTracker(input, tracker).select(3);
        int expected = 1;
        assertThat(tracker.findAll().size(), is(expected));
    }
    /**
     * Test FindByIdAction class.
     */
    @Test
    public void whenExecuteFindByIdActionThenGetSameItem() {
        Item sameItem = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(sameItem);
        String[] answers = new String[]{sameItem.getId()};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new MenuTracker(input, tracker).select(4);
        String expected = new StringJoiner(System.lineSeparator()).add("Введите id заявки: ").add(sameItem.toString()).add("").toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test FindByIdAction class.
     */
    @Test
    public void whenExecuteFindByIdActionThenNoItem() {
        Item sameItem = new Item("SomeName", "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(sameItem);
        String[] answers = new String[]{"NoSuchId"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new MenuTracker(input, tracker).select(4);
        String expected = new StringJoiner(System.lineSeparator()).add("Введите id заявки: ").add("Заявки с заданым id несущетсвует.").add("").toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test FindByNameAction class.
     */
    @Test
    public void whenExecuteFindByNameThenGetItemWithSameName() {
        String sameName = "SameName";
        Item item = new Item(sameName, "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = new String[]{item.getName()};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new MenuTracker(input, tracker).select(5);
        String expected = new StringJoiner(System.lineSeparator()).add("Введите название заявки: ").add(item.toString()).add("").toString();
        assertThat(baos.toString(), is(expected));
    }
    /**
     * Test FindByNameAction class.
     */
    @Test
    public void whenExecuteFindByNameThenGetNoItem() {
        String sameName = "SameName";
        Item item = new Item(sameName, "SomeDesc");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = new String[]{"NoName"};
        Input input = new StubInput(answers);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new MenuTracker(input, tracker).select(5);
        String expected = new StringJoiner(System.lineSeparator()).add("Введите название заявки: ").add("Заявок с заданным именем не найдено.").add("").toString();
        assertThat(baos.toString(), is(expected));
    }
}
