package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.ConsoleInput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class ConsoleInputTest {
    /**
     * Test ask(String, int[]) method.
     */
    @Test
    public void whenInvokeAskThenGetTwo() {
        String key = "2";
        ByteArrayInputStream bais = new ByteArrayInputStream(key.getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        int[] range = new int[]{1, 2, 3, 4};
        ConsoleInput input = new ConsoleInput(scanner);
        int result = input.ask("", range);
        int expected = Integer.parseInt(key);
        assertThat(result, is(expected));
    }

    /**
     * Test ask(String, int[]) method.
     */
    @Test
    public void whenInvokeAskThenGetMenuOutExceptionMessage() {
        String key = "10";
        ByteArrayInputStream bais = new ByteArrayInputStream(key.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        int[] range = new int[]{1, 2, 3, 4};
        System.setOut(new PrintStream(baos));
        ConsoleInput input = new ConsoleInput(scanner);
        try {
            input.ask("", range);
        } catch (RuntimeException e) {
            System.out.print(e.getMessage());
        }
        String result = baos.toString();
        String expected = String.format("%sOut of ru.job4j.menu range", System.lineSeparator());
        assertThat(result, is(expected));
    }
}