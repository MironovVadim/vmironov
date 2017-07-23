package menu;

import org.junit.Test;
import ru.job4j.menu.MenuController;

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
    public void whenPrintMenuThenGetFourStrings() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        MenuController controller = new MenuController();
        String item1 = "item1";
        String item2 = "item2";
        String item3 = "item3";
        int[] paragraph3 = new int[]{1};
        String item4 = "item4";
        int[] paragraph4 = new int[]{1, 1};
        controller.addMenuItem(item1);
        controller.addMenuItem(item2);
        controller.addMenuItem(item3, paragraph3);
        controller.addMenuItem(item4, paragraph4);
        controller.printMenu();
        sj.add(String.format("%s. %s", 1, item1));
        sj.add(String.format("--- %s. %s", "1.1", item3));
        sj.add(String.format("------ %s. %s", "1.1.1", item4));
        sj.add(String.format("%s. %s", 2, item2));
        sj.add("");
        String result = baos.toString();
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test action() method.
     */
    @Test
    public void whenInvokeActionThenPrintActionString() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        MenuController controller = new MenuController();
        String item1 = "item1";
        String item2 = "item2";
        int[] paragraph2 = new int[]{1};
        int[] actionParagraph1 = new int[]{1};
        int[] actionParagraph2 = new int[]{1, 1};

        controller.addMenuItem(item1);
        controller.addMenuItem(item2, paragraph2);
        controller.action(actionParagraph1);
        controller.action(actionParagraph2);
        sj.add("item1: action.");
        sj.add("item2: action.");
        sj.add("");
        String result = baos.toString();
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test action() method.
     */
    @Test
    public void whenInvokeActionThengetMenuItemExceptionMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        MenuController controller = new MenuController();
        String item1 = "item1";
        int[] nonexistentParagraph = new int[]{1, 1};
        controller.addMenuItem(item1);
        controller.action(nonexistentParagraph);
        String result = baos.toString();
        String expected = String.format("MenuItem %s. is not exist.%s", "1.1", System.lineSeparator());
        assertThat(result, is(expected));
    }
}