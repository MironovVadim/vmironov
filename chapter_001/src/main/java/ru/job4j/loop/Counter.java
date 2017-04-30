/**
* Sum of even numbers from start to finish
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.loop;

/**
* class for sum even numbers.
*/
public class Counter {
	/**
	* Method for sum of even numbers in range.
	* @param start - start of range
	* @param finish - end of range
	* @return result - sum of even numbers in range
	*/
	public int add(int start, int finish) {
		int result = 0;
		int number = start + start % 2;
		while (number <= finish) {
			result += number;
			number += 2;
		}
		return result;
	}
}