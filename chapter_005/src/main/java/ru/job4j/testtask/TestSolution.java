/**
 * Class TestSolution.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.testtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Класс для получения полного списка подразделений.
 */
public class TestSolution {
    /**
     * Массив подразделений.
     */
    private String[] subDivisions;

    /**
     * Конструктор принимающий массив подрязделений.
     * @param subDivisions - массив подразделений
     */
    public TestSolution(String[] subDivisions) {
        this.subDivisions = subDivisions;
    }

    /**
     * Метод дополняет массив подразделений отсутствующими подразделениями.
     */
    public void addMissingSubDivisions() {
        List<String> allSubDiv = new ArrayList<>();
        for (String subDiv : subDivisions) {
            if (!allSubDiv.contains(subDiv)) {
                allSubDiv.add(subDiv);
            }
            int lastSeparator = subDiv.lastIndexOf("\\");
            while (lastSeparator != -1) {
                subDiv = subDiv.substring(0, lastSeparator);
                if (!allSubDiv.contains(subDiv)) {
                    allSubDiv.add(subDiv);
                }
                lastSeparator = subDiv.lastIndexOf("\\");
            }
        }
        String[] allSubDivArray = allSubDiv.toArray(new String[0]);
        subDivisions = allSubDivArray;
    }

    /**
     * Метод сортирует массив по алфавиту.
     */
    public void incrSort() {
        Arrays.sort(subDivisions, Comparator.naturalOrder());
    }

    /**
     * Метод сортирует массив подразделений в обратном порядке.
     */
    public void reduceSort() {
        Arrays.sort(subDivisions, Comparator.reverseOrder());
    }

    /**
     * subDivisions getter.
     * @return subDivisions
     */
    public String[] getSubDivisions() {
        return subDivisions;
    }

    @Override
    public String toString() {
        return "TestSolution{"
                + "subDivisions=" + Arrays.toString(subDivisions) + '}';
    }
}
