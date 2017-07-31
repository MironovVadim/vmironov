/**
* removing duplicates from String array.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.array;

import java.util.Arrays;
/**
* Class for removing duplicates from String array.
*/
public class ArrayDuplicate {
	/**
	* Method for removing duplicates from String array.
	* @param array - int[] for removing duplicates
	* @return int[] - array after removing duplicates
	*/
	public String[] remove(String[] array) {
		int resultSize = array.length;
		for (int i = 0; i < resultSize; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[i].equals(array[j])) {
					resultSize--;
					for (int t = j; t < array.length - 1; t++) {
						array[t] = array[t + 1];
					}
				}
			}
		}
		return Arrays.copyOf(array, resultSize);
	}
}