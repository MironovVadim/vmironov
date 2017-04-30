/**
* Painting piramid.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.loop;

/**
* class for painting piramid.
*/
public class Paint {
	/**
	* Method for painting piramid.
	* @param h - height of piramid
	* @return String - piramid
	*/
	public String piramid(int h) {
		StringBuilder sb = new StringBuilder();
		int stringLength = h * 2 - 1;
		for (int i = 1; i <= h; i++) {
			int numberOfSimbols = i * 2 - 1;
			int numberOfSpaces = stringLength - numberOfSimbols;
			for (int j = 0; j < numberOfSpaces / 2; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < numberOfSimbols; j++) {
				sb.append("^");
			}
			for (int j = 0; j < numberOfSpaces / 2; j++) {
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
}