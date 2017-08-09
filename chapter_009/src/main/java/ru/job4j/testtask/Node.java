package ru.job4j.testtask;

import java.util.StringJoiner;

/**
 * LinkedList Node.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Node {
    /**
     * Next Node.
     */
    Node next;
    /**
     * value of node.
     */
    int number;
    /**
     * Default constructor.
     * @param number - value.
     */
    public Node(int number) {
        this.number = number;
    }

    /**
     * Method adds new node.
     * @param number - new value.
     */
    public void nextNode(int number) {
        Node newNode = new Node(number);
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(" ");
        Node current = this;
        int i = 0;
        while (current != null && i++ != 10) {
            result.add(Integer.toString(current.number));
            current = current.next;
        }
        return result.toString();
    }
}
