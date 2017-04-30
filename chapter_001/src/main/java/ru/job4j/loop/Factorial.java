/**
* Factorial of some number.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.loop;

/**
* class for calculate factorial of number.
*/
public class Factorial {
	/**
	* Method for calculate factorial.
	* @param n - last number in range of numbers for calculate factorial.
	* @return result - factorial of n
	*/
	public int calc(int n) {
		int result = 1;
		for (int number = 1; number <= n; number++) {
			result *= number;
		}
		return result;
	}
}