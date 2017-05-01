/**
* Search area of triangle.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.condition;

/**
* Class for search area of three points.
*/
public class Triangle {
	/**
	* First point of triangle.
	*/
	private Point a;
	/**
	* Second point of triangle.
	*/
	private Point b;
	/**
	* Third point of triangle.
	*/
	private Point c;
	/**
	* Constructor.
	* @param a - first point of triangle
	* @param b - second point of triangle
	* @param c - third point of triangle
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	* @return - area of triangle
	*/
	public double area() {
		return Math.abs(0.5D * ((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY())));
	}
}
