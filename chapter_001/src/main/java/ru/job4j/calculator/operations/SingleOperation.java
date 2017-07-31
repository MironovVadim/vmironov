package ru.job4j.calculator.operations;

/**
 * Single math operation.
 */
public interface SingleOperation {

    /**
     * Method return key of operation.
     * @return key of operation.
     */
    String key();

    /**
     *  Method do operation with two numbers.
     * @param first first number.
     * @param second second number.
     * @return result of calculation.
     */
    double doOperation(double first, double second);
}
