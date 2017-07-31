package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ValidateInputClass.
 */
public class ValidateInputTest {
    /**
     * Test ask(String, int[]) method.
     */
    @Test
    public void whenInvokeAskThenGetTwo() {
        String key = "2";
        ByteArrayInputStream bais = new ByteArrayInputStream(key.getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        int[] range = new int[]{1, 2, 3, 4};
        ValidateInput input = new ValidateInput(scanner);
        int result = input.ask("", range);
        int expected = Integer.parseInt(key);
        assertThat(result, is(expected));
    }

    /**
     * Test ask(String, int[]) method.
     */
    @Test
    public void whenInvokeAskThenGetMenuOutExceptionMessage() {
        String key = String.format("10%s4", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(key.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        int[] range = new int[]{1, 2, 3, 4};
        System.setOut(new PrintStream(baos));
        ValidateInput input = new ValidateInput(scanner);
        input.ask("", range);
        String result = baos.toString();
        String expected = String.format("%sPlease enter validate data.%1$s%1$s", System.lineSeparator());
        assertThat(result, is(expected));
    }

    /**
     * Test ask(String, int[]) method.
     */
    @Test
    public void whenInvokeAskThenGetNumberFormatExceptionMessage() {
        String key = String.format("q%s4", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(key.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        int[] range = new int[]{1, 2, 3, 4};
        System.setOut(new PrintStream(baos));
        ValidateInput input = new ValidateInput(scanner);
        input.ask("", range);
        String result = baos.toString();
        String expected = String.format("%sPlease enter the number.%1$s%1$s", System.lineSeparator());
        assertThat(result, is(expected));
    }
}