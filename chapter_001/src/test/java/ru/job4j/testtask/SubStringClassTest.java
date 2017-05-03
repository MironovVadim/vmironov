/**
* Test.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class SubStringClassTest {
	/**
	* Test method.
	*/
	@Test
	public void whenStringContainsSubStringThenTrue() {
		String origin = "The Java language provides special support for the string concatenation operator ( + )";
		String sub = "support for the string ";
		SubStringClass testTask = new SubStringClass();
		boolean result = testTask.contains(origin, sub);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}