package ru.job4j.testtask;

/**
 * Class reverses list.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Reverser {
    /**
     * First Node.
     */
    private Node node;

    /**
     * Default constructor.
     * @param node - first node.
     */
    public Reverser(Node node) {
        this.node = node;
    }

    /**
     * Method reverses Node list.
     */
    public void reverse() {
        if (node.next != null) {
            reverse(this.node);
        }
    }

    /**
     * Node getter.
     * @return node.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Method reverses Node List.
     * @param currentNode - next node of list.
     */
    private void reverse(Node currentNode) {
        Node nextNode = currentNode.next;
        if (nextNode.next != null) {
            reverse(currentNode.next);
        } else {
            this.node = nextNode;
        }
        currentNode.next = null;
        nextNode.next = currentNode;
    }
}
