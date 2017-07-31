package ru.job4j.tree;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class TreeNodeTest {
    /**
     * Test dfsReverse() method.
     */
    @Test
    public void whenDisplayTreeThenGetReversedDisplayedTree() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        TreeNode<Integer> tree = new TreeNode<>(30);
        tree.addNode(20);
        tree.addNode(21);
        tree.addNode(33);
        tree.addNode(15);
        tree.addNode(40);
        tree.addNode(4);
        tree.addNode(8);
        tree.addNode(35);
        tree.dfsReverse();
        tree.displayTree();
        String result = baos.toString();
        sj.add("                                30                                                              ");
        sj.add("                33                              20                              ");
        sj.add("        40              --              21              15              ");
        sj.add("    --      35      --      --      --      --      --      4      ");
        sj.add("  --  --  --  --  --  --  --  --  --  --  --  --  --  --  8  --  ");
        sj.add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test bfsReverse() method.
     */
    @Test
    public void whenDisplayTreeThenGetAnotherReversedDisplayedTree() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        TreeNode<Integer> tree = new TreeNode<>(30);
        tree.addNode(20);
        tree.addNode(21);
        tree.addNode(33);
        tree.addNode(15);
        tree.addNode(40);
        tree.addNode(4);
        tree.addNode(8);
        tree.addNode(35);
        tree.bfsReverse();
        tree.displayTree();
        String result = baos.toString();
        sj.add("                                30                                                              ");
        sj.add("                33                              20                              ");
        sj.add("        40              --              21              15              ");
        sj.add("    --      35      --      --      --      --      --      4      ");
        sj.add("  --  --  --  --  --  --  --  --  --  --  --  --  --  --  8  --  ");
        sj.add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }
    /**
     * Test displayTree() method.
     */
    @Test
    public void whenDisplayTreeThenGetDisplayedTree() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        TreeNode<Integer> tree = new TreeNode<>(30);
        tree.addNode(20);
        tree.addNode(21);
        tree.addNode(33);
        tree.addNode(15);
        tree.addNode(40);
        tree.addNode(4);
        tree.addNode(8);
        tree.addNode(35);
        tree.displayTree();
        String result = baos.toString();
        sj.add("                                30                                                              ");
        sj.add("                20                              33                              ");
        sj.add("        15              21              --              40              ");
        sj.add("    4      --      --      --      --      --      35      --      ");
        sj.add("  --  8  --  --  --  --  --  --  --  --  --  --  --  --  --  --  ");
        sj.add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }
}