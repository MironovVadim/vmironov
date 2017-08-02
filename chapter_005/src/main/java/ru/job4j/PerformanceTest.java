/**
 * Class PerformanceTest.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Random;

/**
 * Class for Collection test.
 */
public class PerformanceTest {
    /**
     * Add operation test.
     * @param collection collection for test
     * @param amount number of elements
     * @return total operation time
     */
    public long add(Collection<String> collection, int amount) {
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.format("%dRandomString%d", random.nextInt(10000000), random.nextInt(10000000)));
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * Delete operation test.
     * @param collection collection for test
     * @param amount number of elements
     * @return total operation time
     */
    public long delete(Collection<String> collection, int amount) {
        Iterator<String> it = collection.iterator();
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            it.next();
            it.remove();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * main method.
     * @param args - massif
     */
    public static void main(String[] args) {
        System.out.println(new Integer(12).hashCode());
        PerformanceTest pt = new PerformanceTest();
        Collection<String> arrayList = new ArrayList<>();
        Collection<String> linkedList = new LinkedList<>();
        Collection<String> treeSet = new TreeSet<>();
        long arrayListTime = pt.add(arrayList, 1500000);
        long linkedListTime = pt.add(linkedList, 1500000);
        long treeSetTime = pt.add(treeSet, 1500000);
        System.out.println(String.format("Добавление в ArrayList: %d", arrayListTime));
        System.out.println(String.format("Добавление в LinkedList: %d", linkedListTime));
        System.out.println(String.format("Добавление в TreeSet: %d", treeSetTime));
        //long arrayListDeleteTime = pt.delete(arrayList, 10000);
        long linkedListDeleteTime = pt.delete(linkedList, 500000);
        long treeSetDeleteTime = pt.delete(treeSet, 500000);
        //System.out.println(String.format("Удаление в ArrayList: %d", arrayListDeleteTime));
        System.out.println(String.format("Удаление в LinkedList: %d", linkedListDeleteTime));
        System.out.println(String.format("Удаление в TreeSet: %d", treeSetDeleteTime));
    }

}