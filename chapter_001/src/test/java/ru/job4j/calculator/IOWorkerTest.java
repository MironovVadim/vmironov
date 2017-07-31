package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculator.operations.AddOperation;
import ru.job4j.calculator.Calculator;
import ru.job4j.calculator.IOWorker;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class IOWorkerTest {
    /**
     * Test InputOperand() method.
     */
    @Test
    public void whenInputOperandThenGetNumberFormatExceptionMessage() {
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("notNumber").add("4");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        System.setOut(new PrintStream(baos));
        String[] commands = new Calculator().getAllKeys();
        IOWorker worker = new IOWorker(commands, reader);
        String stringForPrint = "Some String";
        worker.inputOperand(stringForPrint);
        String result = baos.toString();
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(stringForPrint).add("Введены некорректные данные. Попробуйте еще раз.");
        sj.add(stringForPrint).add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test InputOperand() method.
     */
    @Test
    public void whenInputOperandThenGetFour() {
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("notNumber").add("4");
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        String[] commands = new Calculator().getAllKeys();
        IOWorker worker = new IOWorker(commands, reader);
        String stringForPrint = "Some String";
        double result = worker.inputOperand(stringForPrint);
        double expected = 4;
        assertThat(result, is(expected));
    }

    /**
     * Test InputOperation() method.
     */
    @Test
    public void whenInputOperationThenGetIOExceptionMessage() {
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("notNumber").add("+");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        System.setOut(new PrintStream(baos));
        String[] commands = new Calculator().getAllKeys();
        IOWorker worker = new IOWorker(commands, reader);
        String stringForPrint = "Some String";
        worker.inputOperation(stringForPrint);
        String result = baos.toString();
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add(stringForPrint).add("Введены некорректные данные. Попробуйте еще раз.");
        sj.add(stringForPrint).add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test InputOperation() method.
     */
    @Test
    public void whenInputOperandThenGetPlus() {
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("notNumber").add(new AddOperation().key());
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        String[] commands = new Calculator().getAllKeys();
        IOWorker worker = new IOWorker(commands, reader);
        String stringForPrint = "Some String";
        String result = worker.inputOperation(stringForPrint);
        String expected = new AddOperation().key();
        assertThat(result, is(expected));
    }

    /**
     * Test isContinue() method.
     */
    @Test
    public void whenInvokeIsContinueThenGetIOExceptionMessage() {
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("t").add("y");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        System.setOut(new PrintStream(baos));
        IOWorker worker = new IOWorker(null, reader);
        worker.isContinue();
        String result = baos.toString();
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        String stringFromMethod = "Продолжить операции с предыдущим результатом? y/n";
        sj.add(stringFromMethod);
        sj.add("Введены некорректные данные. Попробуйте еще раз.");
        sj.add(stringFromMethod);
        sj.add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test isContinue() method.
     */
    @Test
    public void whenInvokeIsContinueThenGetTrue() {
        String answer = String.format("y%s", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(answer.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        IOWorker worker = new IOWorker(null, reader);
        boolean result = worker.isContinue();
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test isContinue() method.
     */
    @Test
    public void whenInvokeIsContinueThenGetFalse() {
        String answer = String.format("n%s", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(answer.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        IOWorker worker = new IOWorker(null, reader);
        boolean result = worker.isContinue();
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test isExit() method.
     */
    @Test
    public void whenInvokeIsExitThenGetIOExceptionMessage() {
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("t").add("y");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        System.setOut(new PrintStream(baos));
        IOWorker worker = new IOWorker(null, reader);
        worker.isExit();
        String result = baos.toString();
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        String stringFromMethod = "Закончить операции? y/n";
        sj.add(stringFromMethod);
        sj.add("Введены некорректные данные. Попробуйте еще раз.");
        sj.add(stringFromMethod);
        sj.add("");
        String expected = sj.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test isExit() method.
     */
    @Test
    public void whenInvokeIsExitThenGetTrue() {
        String answer = "y";
        ByteArrayInputStream bais = new ByteArrayInputStream(answer.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        IOWorker worker = new IOWorker(null, reader);
        boolean result = worker.isExit();
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test isExit() method.
     */
    @Test
    public void whenInvokeIsExitThenGetFalse() {
        String answer = "n";
        ByteArrayInputStream bais = new ByteArrayInputStream(answer.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        IOWorker worker = new IOWorker(null, reader);
        boolean result = worker.isExit();
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
