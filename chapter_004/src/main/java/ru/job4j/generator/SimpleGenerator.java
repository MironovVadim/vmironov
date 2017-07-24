package ru.job4j.generator;


import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple Generator.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleGenerator {
    /**
     * Template.
     */
    private static final String TEMPLATE = "\\$\\{\\w*}";

    /**
     * Method replace all templates in string on words stored in map. Then print it.
     * @param str - string with templates for replacement.
     * @param words - map with words instead templates.
     * @throws WordsAmountException if map contains extra words or there are was not some word for template.
     */
    public void replaceString(String str, Map<String, String> words) throws WordsAmountException {
        String result = str;
        Pattern pattern = Pattern.compile(this.TEMPLATE);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String key = matcher.group().substring(2, matcher.group().length() - 1);
            String word = words.get(key);
            if (word == null) {
                throw new WordsAmountException();
            }
            result = result.replace(matcher.group(), word);
        }
        for (String word : words.values()) {
            if (!result.contains(word)) {
                throw new WordsAmountException();
            }
        }
        System.out.println(result);
    }
}
