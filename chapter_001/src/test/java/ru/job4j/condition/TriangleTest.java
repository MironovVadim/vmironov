/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.condition.Point;
import ru.job4j.condition.Triangle;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class TriangleTest {
	/**
	* Test method.
	*/
	@Test
	public void whenOneTwoAndThreeFourAndFiveSixThenZero() {
		Point point1 = new Point(1, 2);
		Point point2 = new Point(3, 4);
		Point point3 = new Point(5, 6);

		Triangle triangle = new Triangle(point1, point2, point3);
		double result = triangle.area();
		double expected = 0D;
		assertThat(result, closeTo(expected, 0.01));
	}
}