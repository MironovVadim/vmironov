/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class MaxTest {
	/**
	* testtask method.
	*/
	@Test
	public void whenCompareFiveAndThreeThenFive() {
		Max max = new Max();
		int result = max.max(5, 3);
		int expected = 5;
		assertThat(result, is(expected));
	}
	/**
	* testtask method.
	*/
	@Test
	public void whenCompareFiveAndSixAndSevenThenSeven() {
		Max max = new Max();
		int result = max.max(5, 6, 7);
		int expected = 7;
		assertThat(result, is(expected));
	}
}