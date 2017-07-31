/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class RotateArrayTest {
	/**
	* Test method.
	*/
	@Test
	public void whenRotateSquareArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] result = rotateArray.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		int[][] expected = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(result, is(expected));
	}
}