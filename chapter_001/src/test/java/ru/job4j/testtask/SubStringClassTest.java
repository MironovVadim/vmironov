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
	public void whenStringIsNotContainsSubStringThenFalse() {
		String origin = " An enum is a kind of class and an annotation";
		String sub = "clss";
		SubStringClass testTask = new SubStringClass();
		boolean result = testTask.contains(origin, sub);
		boolean expected = false;
		assertThat(result, is(expected));
	}
	/**
	* Test method.
	*/
	@Test
	public void whenStringContainsSubStringThenTrue() {
		String origin = "Instances of the class Class";
		String sub = "class";
		SubStringClass testTask = new SubStringClass();
		boolean result = testTask.contains(origin, sub);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}