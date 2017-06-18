/**
 * Test TestSolution class.
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
 * Test TestSolution class.
 */
public class TestSolutionTest {
    /**
     * Test addMissingSubDivisions() method.
     */
    @Test
    public void whenSetSubDivThenGetAllSubDiv() {
        String[] subDivisions = new String[]{"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        TestSolution test = new TestSolution(subDivisions);
        test.addMissingSubDivisions();
        test.incrSort();
        String[] result = test.getSubDivisions();
        String[] expected = new String[]{"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(result, is(expected));
    }
}
