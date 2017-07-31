package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculator.Calculator;
import ru.job4j.calculator.IOWork;
import ru.job4j.calculator.InteractCalc;
import ru.job4j.calculator.StubIOWorker;

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
