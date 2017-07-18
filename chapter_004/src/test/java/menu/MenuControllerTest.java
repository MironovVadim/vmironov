package menu;

import org.junit.Test;
import ru.job4j.menu.MenuController;
import ru.job4j.menu.MenuItem;
import ru.job4j.menu.MenuItemImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuControllerTest {
    /**
     * Test printMenu() method.
     */
    @Test
    public void whenPrintMenuThenGetPrintSevenStrings() {
        MenuController controller = new MenuController();
        MenuItem item1 = new MenuItemImpl("Item1");
        MenuItem item2 = new MenuItemImpl("Item2");
        MenuItem item3 = new MenuItemImpl("Item3");
        MenuItem item4 = new MenuItemImpl("Item4");
        MenuItem item5 = new MenuItemImpl("Item5");
        MenuItem item6 = new MenuItemImpl("Item6");
        MenuItem item7 = new MenuItemImpl("Item7");
        controller.addMenuItem(item6, 10);
        controller.addMenuItem(item5, 2);
        controller.addMenuItem(item7, 1, 1, 2);
        controller.addMenuItem(item4, 1, 1, 1, 1);
        controller.addMenuItem(item1, 1);
        controller.addMenuItem(item3, 1, 1, 1);
        controller.addMenuItem(item2, 1, 1);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        controller.printMenu();
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(String.format("1 %s", item1.getName()));
        sj.add(String.format("--- 1.1 %s", item2.getName()));
        sj.add(String.format("------ 1.1.1 %s", item3.getName()));
        sj.add(String.format("--------- 1.1.1.1 %s", item4.getName()));
        sj.add(String.format("------ 1.1.2 %s", item7.getName()));
        sj.add(String.format("2 %s", item5.getName()));
        sj.add(String.format("10 %s", item6.getName()));
        sj.add("");
        String result = baos.toString();
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test action() method.
     */
    @Test
    public void whenInvokeActionThenPrintTwoStrings() {
        MenuController controller = new MenuController();
        MenuItem item1 = new MenuItemImpl("Item1");
        MenuItem item2 = new MenuItemImpl("Item2");
        controller.addMenuItem(item1, 1);
        controller.addMenuItem(item2, 1, 1, 2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        controller.action(1);
        controller.action(1, 1, 2);
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(String.format("%s: action.", item1.getName()));
        sj.add(String.format("%s: action.", item2.getName()));
        sj.add("");
        String result = baos.toString();
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test action() method.
     */
    @Test
    public void whenInvokeActionThenPrintStringThatCantInvokeAction() {
        MenuController controller = new MenuController();
        MenuItem item1 = new MenuItemImpl("Item1");
        controller.addMenuItem(item1, 1);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        controller.action(1, 1, 2);
        StringJoiner sj = new StringJoiner(".");
        sj.add(Integer.toString(1)).add(Integer.toString(1)).add(Integer.toString(2));
        String result = baos.toString();
        String expected = String.format("%s paragraph does not exist.%s", sj.toString(), System.lineSeparator());
        assertThat(result, is(expected));
    }
}
