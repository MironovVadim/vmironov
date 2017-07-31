package ru.calculator.operations;

/**
 * Multiply operation.
 */
public class MultiplyOperation implements SingleOperation {
    /**
     * String key of multiply operation.
     */
    private final String key = "*";

    @Override
    public String key() {
        return key;
    }

    @Override
    public double doOperation(double first, double second) {
        return first * second;
    }
}
