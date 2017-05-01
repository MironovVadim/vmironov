/**
* Test
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*/
public class TurnTest {
	/**
	* Test method.
	*/
	@Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
		Turn turn = new Turn();
		int[] result = turn.back(new int[]{1, 2, 3, 4, 5, 6});
		int[] expected = new int[]{6, 5, 4, 3, 2, 1};
		assertThat(result, is(expected));
    }
	/**
	* Test method.
	*/
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
		Turn turn = new Turn();
		int[] result = turn.back(new int[]{1, 2, 3, 4, 5});
		int[] expected = new int[]{5, 4, 3, 2, 1};
		assertThat(result, is(expected));
	}
}