/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class BoardTest {
	/**
	* Test method.
	*/
	@Test
	public void whenWidthThreeAndHeightThreeThenStringWithThreeRowsAndThreeCols() {
		Board board = new Board();
		String result = board.paint(3, 3);
		String expected = "X X\n X \nX X";
		assertThat(result, is(expected));
	}
	/**
	* Test method.
	*/
	@Test
	public void whenPaintFiveAndFourThenStringWithFiveRowsAndFourCols() {
		Board board = new Board();
		String result = board.paint(5, 4);
		String expected = "X X X\n X X \nX X X\n X X ";
		assertThat(result, is(expected));
	}
}