package ru.job4j;

import java.util.*;

public class PerformanceTest {

    public long add(Collection<String> collection, int amount) {
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.format("%dRandomString%d", random.nextInt(1000000), random.nextInt(1000000)));
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

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

    public static void main(String[] args) {
        PerformanceTest pt = new PerformanceTest();
        Collection<String> arrayList = new ArrayList<>();
        Collection<String> linkedList = new LinkedList<>();
        Collection<String> treeSet = new TreeSet<>();
        long arrayListTime = pt.add(arrayList, 500000);
        long linkedListTime = pt.add(linkedList, 500000);
        long treeSetTime = pt.add(treeSet, 500000);
        System.out.println(String.format("Добавление в ArrayList: %d", arrayListTime));
        System.out.println(String.format("Добавление в LinkedList: %d", linkedListTime));
        System.out.println(String.format("Добавление в TreeSet: %d", treeSetTime));
        long arrayListDeleteTime = pt.delete(arrayList, 10000);
        long linkedListDeleteTime = pt.delete(linkedList, 10000);
        long treeSetDeleteTime = pt.delete(treeSet, 10000);
        System.out.println(String.format("Удаление в ArrayList: %d", arrayListDeleteTime));
        System.out.println(String.format("Удаление в LinkedList: %d", linkedListDeleteTime));
        System.out.println(String.format("Удаление в TreeSet: %d", treeSetDeleteTime));
    }
}