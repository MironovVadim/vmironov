package ru.job4j.calculator.operations;

/**
 * Class that do an operation that returns a number that is the percentage of the second of the first.
 */
public class PercentageOperation implements SingleOperation {
    /**
     * Key of the operation that returns a number that is the percentage of the second of the first.
     */
    private String key = "%";
    @Override
    public String key() {
        return key;
    }

    @Override
    public double doOperation(double first, double second) {
        return first / 100 * second;
    }
}
