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
     * RE template.
     */
    private static final String TEMPLATE = "(\\$\\{)(\\w*)(})";
    /**
     * Template.
     */
    private static final Pattern PATTERN = Pattern.compile(TEMPLATE);

    /**
     * Method replace all templates in string on words stored in map. Then print it.
     * @param str - string with templates for replacement.
     * @param words - map with words instead templates.
     * @throws WordsAmountException if map contains extra words or there are was not some word for template.
     */
    public void replaceString(String str, Map<String, String> words) throws WordsAmountException {
        StringBuffer sb = new StringBuffer();
        Matcher matcher = PATTERN.matcher(str);
        while (matcher.find()) {
            String key = matcher.group(2);
            String word = words.get(key);
            if (word == null) {
                throw new WordsAmountException();
            }
           matcher.appendReplacement(sb, word);
        }
        matcher.appendTail(sb);
        String result = sb.toString();
        for (String word : words.values()) {
            if (!result.contains(word)) {
                throw new WordsAmountException();
            }
        }
        System.out.println(result);
    }
}
