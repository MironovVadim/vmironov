package ru.job4j.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ReverserTest {
    /**
     * Test reverse(Node) method.
     */
    @Test
    public void whenReverseListThenGetReversedList() {
        Node node = new Node(1);
        for (int i = 2; i < 6; i++) {
            node.nextNode(i);
        }
        Reverser rev = new Reverser(node);
        Node expectedNode = new Node(5);
        for (int i = 4; i > 0; i--) {
            expectedNode.nextNode(i);
        }
        rev.reverse();
        String result = rev.getNode().toString();
        String expected = expectedNode.toString();

        assertThat(result, is(expected));
    }

}