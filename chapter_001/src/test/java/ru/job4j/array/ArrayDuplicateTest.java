/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.array;

import org.junit.Test;
import ru.job4j.array.ArrayDuplicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class ArrayDuplicateTest {
	/**
	* Test method.
	*/
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
		String[] result = arrayDuplicate.remove(new String[]{"Hello", "World", "Hello", "Super", "World"});
		String[] expected = {"Hello", "World", "Super"};
		assertThat(result, is(expected));
	}
}