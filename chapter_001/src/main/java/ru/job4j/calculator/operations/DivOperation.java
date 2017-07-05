package ru.job4j.calculator.operations;

/**
 * Division operation.
 */
public class DivOperation implements SingleOperation {
    /**
     * String key of division operation.
     */
    private final String key = "/";

    @Override
    public String key() {
        return key;
    }

    @Override
    public double doOperation(double first, double second) {
        return first / second;
    }
}
