/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class CalculatorTest {
	/**
	* Test for adding operation.
	*/
	@Test
	public void whenAddTwoPlusFiveThenSeven() {
		Calculator calc = new Calculator();
		calc.doSingleOperation(2D, "+", 5D);
		double result = calc.getResult();
		double expected = 7D;
		assertThat(result, is(expected));
	}
	/**
	* Test for substract operation.
	*/
	@Test
	public void whenSubstractTwoFromSevenThenFive() {
		Calculator calc = new Calculator();
		calc.doSingleOperation(7D, "-", 2D);
		double result = calc.getResult();
		double expected = 5D;
		assertThat(result, is(expected));
	}
	/**
	* Test for division operation.
	*/
	@Test
	public void whenDivideSevenOnTwoThenThreeAndAHalf() {
		Calculator calc = new Calculator();
		calc.doSingleOperation(7D, "/", 2D);
		double result = calc.getResult();
		double expected = 3.5D;
		assertThat(result, is(expected));
	}
	/**
	* Test for multiply operation.
	*/
	@Test
	public void whenMultipleThreeOnFourThenTwelve() {
		Calculator calc = new Calculator();
		calc.doSingleOperation(3D, "*", 4D);
		double result = calc.getResult();
		double expected = 12D;
		assertThat(result, is(expected));
	}
}