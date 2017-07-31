package ru.job4j.calculator.operations;

/**
 * Substract operation.
 */
public class SubstractOperation implements SingleOperation {
    /**
     * String key of substract operation.
     */
    private final String key = "-";

    @Override
    public String key() {
        return key;
    }

    @Override
    public double doOperation(double first, double second) {
        return first - second;
    }
}
