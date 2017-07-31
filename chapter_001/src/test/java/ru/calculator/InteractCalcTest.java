package ru.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class InteractCalcTest {
    /**
     * Test init() method.
     */
    @Test
    public void whenAddFourWithSixAndAddFiveThenGetFifteen() {
        String[] answers = new String[]{"4", "+", "6", "true", "+", "5", "false", "true"};
        IOWork ioWork = new StubIOWorker(answers);
        Calculator calc = new Calculator();
        InteractCalc calculator = new InteractCalc(calc, ioWork);
        calculator.init();
        double result = calculator.getResultFromCalc();
        double expected = 15;
        assertThat(result, is(expected));
    }
}
