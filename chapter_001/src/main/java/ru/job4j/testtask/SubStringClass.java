/**
 * Searching substring in a string.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.testtask;

/**
 * Class for searcheing substring in a string.
 */
public class SubStringClass {
	/**
	 * Method for searcheing substring in a string.
	 * @param origin - string for searcheing substring
	 * @param sub - substring
	 * @return boolean - is origin contains substring
	 */
	public boolean contains(String origin, String sub) {
		boolean isContains = false;
		char[] originArray = origin.toCharArray();
		char[] subArray = sub.toCharArray();
		for (int i = 0; i < originArray.length - subArray.length; i++) {
			isContains = true;
			for (int j = 0; j < subArray.length; j++) {
				if (originArray[i + j] != subArray[j]) {
					isContains = false;
					break;
				}
			}
			if (isContains) {
				break;
			}
		}
		return isContains;
	}
}