/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class BubbleSortTest {
	/**
	* Test method.
	*/
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort bs = new BubbleSort();
		int[] result = bs.sort(new int[]{5, 1, 2, 7, 3});
		int[] expected = new int[]{1, 2, 3, 5, 7};
		assertThat(result, is(expected));
	}
}