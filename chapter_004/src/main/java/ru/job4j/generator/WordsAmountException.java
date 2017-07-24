package ru.job4j.generator;

/**
 * WordsAmountException.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class WordsAmountException extends Exception {
    /**
     * Default constructor.
     */
    public WordsAmountException() {
        super("Incorrect amount of words in map");
    }
}
