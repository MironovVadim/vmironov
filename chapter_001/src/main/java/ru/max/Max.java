/**
* Search the MaxNumber.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.max;

/**
* Class for search max value among two of three numbers.
*/
public class Max {
	/**
	* @param first - first number
	* @param second - second number
	* @return - max value among two numbers
	*/
	public int max(int first, int second) {
		return first > second ? first : second;
	}
	/**
	* @param first - first number
	* @param second - second number
	* @param third - third number
	* @return - max value among three numbers
	*/
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}