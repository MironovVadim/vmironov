package ru.job4j.generator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.HashMap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleGenerator test class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleGeneratorTest {
    /**
     * Test replaceString() method.
     */
    @Test
    public void whenInvokeReplaceStringThenGetStringAfterReplace() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String forReplace = "I am a ${name}, Who are ${subject}?";
        Map<String, String> words = new HashMap<>();
        String name = "Vadim";
        String subject = "you";
        words.put("name", name);
        words.put("subject", subject);
        try {
            new SimpleGenerator().replaceString(forReplace, words);
        } catch (WordsAmountException e) {
            System.out.println(e.getMessage());
        }
        String result = baos.toString();
        String expected = "I am a Vadim, Who are you?\r\n";
        assertThat(result, is(expected));
    }

    /**
     * Test replaceString() method.
     */
    @Test
    public void whenInvokeReplaceStringThenGetAnotherStringAfterReplace() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String forReplace = "Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> words = new HashMap<>();
        String aaa = "AAA";
        words.put("sos", aaa);
        try {
            new SimpleGenerator().replaceString(forReplace, words);
        } catch (WordsAmountException e) {
            System.out.println(e.getMessage());
        }
        String result = baos.toString();
        String expected = "Help, AAA, AAA, AAA\r\n";
        assertThat(result, is(expected));
    }

    /**
     * Test replaceString() method.
     */
    @Test
    public void whenInvokeReplaceStringThenGetWordsAmountException() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String forReplace = "I am a ${name}, Who are ${subject}?";
        Map<String, String> words = new HashMap<>();
        String name = "Vadim";
        String subject = "you";
        String extra = "SomeString";
        words.put("name", name);
        words.put("subject", subject);
        words.put("extra", extra);
        try {
            new SimpleGenerator().replaceString(forReplace, words);
        } catch (WordsAmountException e) {
            System.out.println(e.getMessage());
        }
        String result = baos.toString();
        String expected = "Incorrect amount of words in map\r\n";
        assertThat(result, is(expected));
    }

    /**
     * Test replaceString() method.
     */
    @Test
    public void whenInvokeReplaceStringThenGetAnotherWordsAmountException() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String forReplace = "I am a ${name}, Who are ${subject}?";
        Map<String, String> words = new HashMap<>();
        String name = "Vadim";
        words.put("name", name);
        try {
            new SimpleGenerator().replaceString(forReplace, words);
        } catch (WordsAmountException e) {
            System.out.println(e.getMessage());
        }
        String result = baos.toString();
        String expected = "Incorrect amount of words in map\r\n";
        assertThat(result, is(expected));
    }
}
