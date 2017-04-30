/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class PointTest {
	/**
	* Test method.
	*/
	@Test
	public void whenTwoWithEightAndThreeWithTwoThenTrue() {
		Point point = new Point(2, 8);
		boolean result = point.is(3, 2);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}