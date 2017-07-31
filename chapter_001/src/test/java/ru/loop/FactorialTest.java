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
public class FactorialTest {
	/**
	* Test method.
	*/
	@Test
	public void whenCalcFiveThenOneHundredAndTwenty() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(5);
		int expected = 120;
		assertThat(result, is(expected));
	}
	/**
	* Test method.
	*/
	@Test
	public void whenCalcZeroThenOne() {
		Factorial factorial = new Factorial();
		int result = factorial.calc(0);
		int expected = 1;
		assertThat(result, is(expected));
	}
}