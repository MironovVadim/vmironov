/**
* Bubble sort.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.array;

/**
* Class for sorting an array.
*/
public class BubbleSort {
	/**
	* Method for bubble sort a array.
	* @param array - int[] for sort
	* @return int[] - array after sort
	*/
	public int[] sort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] =  array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}