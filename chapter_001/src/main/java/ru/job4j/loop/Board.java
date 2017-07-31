/**
* Painting chess board.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.loop;

/**
* class for painting chess board.
*/
public class Board {
	/**
	* Method for painting chess board.
	* @param width - width of chess board
	* @param height - height of chess board
	* @return String - chess board
	*/
	public String paint(int width, int height) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((i + j) % 2 == 0) {
					sb.append("X");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
}