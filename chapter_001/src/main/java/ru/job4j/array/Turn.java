/**
* Class for turning array.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.array;

/**
* Class for turning array.
*/
public class Turn {
	/**
	* Method for turning array.
	* @param array - int[] for turning
	* @return int[] - array after turning
	*/
	public int[] back(int[] array) {
		for (int i = 0, j = array.length - 1; i < j; i++, j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}
}