/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class PaintTest {
	/**
	* Test method.
	*/
	@Test
	public void whenHTwoThenPiramidWithHeightTwo() {
		Paint paint = new Paint();
		String result = paint.piramid(2);
		String expected = " ^ \n^^^";
		assertThat(result, is(expected));
	}
	/**
	* Test method.
	*/
	@Test
	public void whenHThreeThenPiramidWithThreeHeight() {
		Paint paint = new Paint();
		String result = paint.piramid(3);
		String expected = "  ^  \n ^^^ \n^^^^^";
		assertThat(result, is(expected));
	}
}