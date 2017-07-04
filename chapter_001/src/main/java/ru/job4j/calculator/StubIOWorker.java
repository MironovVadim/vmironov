package ru.job4j.calculator;

/**
 * Class for testing InteractCalc.
 */
public class StubIOWorker implements IOWork {
    /**b
     * Array with answers.
     */
    private String[] array;
    /**
     * Number of answer.
     */
    private int count = 0;

    /**
     * Default constructor.
     * @param array - String array with answers.
     */
    public StubIOWorker(String... array) {
        this.array = array;
    }

    @Override
    public String inputOperation(String forPrint) {
        return array[count++];
    }

    @Override
    public double inputOperand(String forPrint) {
        return Double.parseDouble(array[count++]);
    }

    @Override
    public boolean isContinue() {
        return Boolean.parseBoolean(array[count++]);
    }

    @Override
    public boolean isExit() {
        return Boolean.parseBoolean(array[count++]);
    }
}
