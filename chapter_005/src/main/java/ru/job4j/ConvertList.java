/**
 * Class ConvertTest.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Converting List and Array.
 */
public class ConvertList {
    /**
     * Convert array to List.
     * @param array for converting
     * @return list after converting
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * Convert List to Array.
     * @param list for converting
     * @param rows - number of rows
     * @return array[][]
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int row = 0;
        int column = list.size() / rows;
        if (list.size() % rows > 0) {
            column++;
        }
        Iterator<Integer> it = list.iterator();
        int[][] result = new int[column][rows];
        for (int i = 0; i < result.length; i++) {
            for (row = 0; row < result[i].length; row++) {
                if (it.hasNext()) {
                    result[i][row] = it.next();
                } else {
                    break;
                }
            }
        }
        Arrays.fill(result[result.length - 1], row, result[result.length - 1].length - 1, 0);
        return result;
    }

    /**
     * Convert List<int[]> to List<<Integer>.
     * @param list for converting
     * @return converting list
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] massif : list) {
            for (int number : massif) {
                result.add(number);
            }
        }
        return result;
    }
}
