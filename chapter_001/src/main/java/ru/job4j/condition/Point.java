/**
* IsPoint.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.condition;

/**
* Class create point with X, Y coordinates.
*/
public class Point {
	/**
	* X coordinate.
	*/
	private int x;
	/**
	* Y coordinate.
	*/
	private int y;
	/**
	* Constructor.
	* @param x - first coordinate of point
	* @param y - second coordinate of point
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	* @return x - first coordinate of point
	*/
	public int getX() {
		return this.x;
	}
	/**
	* @return y - second coordinate of point
	*/
	public int getY() {
		return this.y;
	}
	/**
	* Method compares two points.
	* @param a - first coordinate of compared point
	* @param b - second coordinate of compared point
	* @return boolean - is compared points lays on the function
	*/
	public boolean is(int a, int b) {
		return y == a * x + b;
	}
}