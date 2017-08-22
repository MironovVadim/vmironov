package ru.job4j.cache;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Cache class.
 */
public class CacheTest {
    /**
     * Test getContentFrom(String) method.
     * @throws IOException - standard IOException
     */
    @Test
    public void whenInvokeGetContentFromThenGetContext() throws IOException {
        String someContent = "SomeContent";
        File tempFile = File.createTempFile("temp", ".tmp");
        new FileWriter(tempFile).write(someContent);
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
        bw.write(someContent);
        bw.close();
        Cache cache = new Cache(tempFile.getParent());

        String result = cache.getContentFrom(tempFile.getName());
        String expected = someContent;

        assertThat(result, is(expected));
    }

}