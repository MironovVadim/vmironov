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
		char[] originArray = origin.toCharArray();
		char[] subArray = sub.toCharArray();
		label: for (int i = 0; i < originArray.length - subArray.length; i++) {
			if (originArray[i] == subArray[0]) {
				boolean isContains = true;
				for (int j = i + 1, t = 1; t < subArray.length; j++, t++) {
					if (originArray[j] != subArray[t]) {
						isContains = false;
						break;
					}
				}
				if (isContains) {
					return true;
				}
			}
		}
		return false;
	}
}