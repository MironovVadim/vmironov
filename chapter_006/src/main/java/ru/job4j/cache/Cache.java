package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

/**
 * Cache class.
 */
public class Cache extends AbstractCache<String, String> {
    /**
     * Path to directory with files.
     */
    private final String path;

    /**
     * Default constructor with path to directory with txt files.
     * @param path to directory with files.
     */
    public Cache(String path) {
        this.path = path;
    }

    @Override
    public String getContentFrom(String fileName) {
        String content = this.getValue(fileName);
        if (content == null) {
           content = this.extractContentFrom(fileName);
           this.addNewPair(fileName, content);
        }
        return content;
    }

    /**
     * Method returns content form fileName.
     * @param fileName - file name with content.
     * @return content of fileName.
     */
    private String extractContentFrom(String fileName) {
        StringJoiner sj = new StringJoiner("\\");
        sj.add(this.path).add(fileName);
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(sj.toString()))) {
            while (br.ready()) {
                content.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
