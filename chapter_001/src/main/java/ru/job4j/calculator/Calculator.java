/**
* Class for math operations.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.calculator;

/**
* Class for simple math operations with two numbers.
*/
public class Calculator {
	/**
	* result after math operation.
	*/
	private double result;
	/**
	* Addition method.
	* @param first - first double value
	* @param second - second double value
	*/
	public void add(double first, double second) {
		result = first + second;
	}
	/**
	* Substraction method.
	* @param first - first double value
	* @param second - second double value
	*/
	public void substract(double first, double second) {
		result = first - second;
	}
	/**
	* Division method.
	* @param first - first double value
	* @param second - second double value
	*/
	public void div(double first, double second) {
		result = first / second;
	}
	/**
	* Multiplication method.
	* @param first - first double value
	* @param second - second double value
	*/
	public void multiple(double first, double second) {
		result = first * second;
	}
	/**
	* @return value - result after math operation
	*/
	public double getResult() {
		return result;
	}
}