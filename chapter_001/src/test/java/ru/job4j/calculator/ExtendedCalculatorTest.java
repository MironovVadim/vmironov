package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class ExtendedCalculatorTest {
    /**
     * Test elevate operation.
     */
    @Test
    public void whenFourElevateInTwoThenGetSixTeen() {
        ExtendedCalculator calc = new ExtendedCalculator();
        calc.doSingleOperation(4, "^", 2);
        double result = calc.getResult();
        double expected = 16d;
        assertThat(result, is(expected));
    }
    /**
     * Test elevate operation.
     */
    @Test
    public void whenPercentageTwentyFiveFromOneHundredThenGetTwentyFive() {
        ExtendedCalculator calc = new ExtendedCalculator();
        calc.doSingleOperation(100, "%", 25);
        double result = calc.getResult();
        double expected = 25d;
        assertThat(result, is(expected));
    }

}
