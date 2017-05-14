/**
 * Test for StartUI class.
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
public class StartUITest {
    /**
     * Test method.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        String[] answers = new String[]{"0", "SomeName", "SomeDesc", "6"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("SomeName"));
    }
}
