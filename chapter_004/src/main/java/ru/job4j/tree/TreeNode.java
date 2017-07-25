package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TreeNode.
 * @param <T> - Integer class.
 */
public class TreeNode<T extends Integer> {
    /**
     * left branch.
     */
    private TreeNode<T> left;
    /**
     * Right branch.
     */
    private TreeNode<T> right;
    /**
     * Value.
     */
    private T value;

    /**
     * Default constructor.
     * @param value - value of TreeNode.
     */
    public TreeNode(T value) {
        this.value = value;
    }

    /**
     * Add new TreeNode.
     * @param value - value of TreeNode.
     */
    public void addNode(T value) {
        TreeNode<T> newNode = new TreeNode<>(value);
        TreeNode<T> current = this;
        TreeNode<T> parent;
        while (true) {
            parent = current;
            if (value.intValue() < current.getValue().intValue()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    /**
     * Reverse tree in BFS.
     */
    public void bfsReverse() {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this);
        while (queue.size() != 0) {
            TreeNode<T> current = queue.poll();
            if (current != null) {
                current.reverseChildren();
                queue.add(current.getLeft());
                queue.add(current.getRight());
            }
        }
    }

    /**
     * Reverse tree in DFS.
     */
    public void dfsReverse() {
        this.dfsReverse(this);
    }

    /**
     * Reverse right and left TreeNodes.
     */
    public void reverseChildren() {
        if (this.left != null && this.right != null) {
            TreeNode<T> temp = this.left;
            this.left = this.right;
            this.right = temp;
        } else if (this.left != null) {
            this.right = this.left;
            this.left = null;
        } else if (this.right != null) {
            this.left = this.right;
            this.right = null;
        }
    }

    /**
     * Left TreeNode getter.
     * @return left TreeNode.
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Left branch setter.
     * @param left - left TreeNode.
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right TreeNode getter.
     * @return right TreeNode.
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Right branch setter.
     * @param right - right TreeNode.
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Value getter.
     * @return value.
     */
    public T getValue() {
        return value;
    }

    /**
     * DFS reverse.
     * @param node - TreeNode for reverse.
     */
    private void dfsReverse(TreeNode<T> node) {
        if (node != null) {
            node.reverseChildren();
            this.dfsReverse(node.getLeft());
            this.dfsReverse(node.getRight());
        }
    }

    /**
     * Display tree like tree with branches.
     */
    public void displayTree() {
        Stack<TreeNode<T>> globalStack = new Stack<TreeNode<T>>();
        globalStack.push(this);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            Stack<TreeNode<T>> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (!globalStack.isEmpty()) {
                TreeNode<T> temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
    }
}