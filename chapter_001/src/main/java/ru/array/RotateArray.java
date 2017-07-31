/**
* Rotating array[][].
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.array;

/**
* Class for rotating an array.
*/
public class RotateArray {
	/**
	* Method for rotating an array.
	* @param array - int[] for rotating
	* @return int[] - array after rotating
	*/
	public int[][] rotate(int[][] array) {
		for (int i = 0; i < array.length / 2; i++) {
            for (int j = i; j < array.length - 1 - i; j++) {
				int temp = array[i][j];
                array[i][j] = array[array.length - 1 - j][i];
                array[array.length - 1 - j][i] = array[array.length - 1 - i][array.length - 1 - j];
                array[array.length - 1 - i][array.length - 1 - j] = array[j][array.length - 1 - i];
                array[j][array.length - 1 - i] = temp;
			}
		}
		return array;
	}
}