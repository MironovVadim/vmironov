package ru.job4j.calculator.operations;

/**
 * Adding operation.
 */
public class AddOperation implements SingleOperation {
    /**
     * String key of adding operation.
     */
    private final String key = "+";

    @Override
    public String key() {
        return key;
    }

    @Override
    public double doOperation(double first, double second) {
        return first + second;
    }
}
