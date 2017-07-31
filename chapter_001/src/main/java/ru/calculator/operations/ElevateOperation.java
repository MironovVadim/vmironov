package ru.calculator.operations;

/**
 * Class for elevating first number in second number.
 */
public class ElevateOperation implements SingleOperation {
    /**
     * String key of elevate operation.
     */
    private final String key = "^";

    @Override
    public String key() {
        return key;
    }

    @Override
    public double doOperation(double first, double second) {
        return Math.pow(first, second);
    }
}
