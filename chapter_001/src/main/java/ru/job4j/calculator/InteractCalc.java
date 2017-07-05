package ru.job4j.calculator;

/**
 * Calculator with IO.
 */
public class InteractCalc {
    /**
     * Simple Calculator.
     */
    private Calculator calc;
    /**
     * Class for working with IO library.
     */
    private IOWork ioWorker;
    /**
     * Continue calculate or start with no result calculation.
     */
    private boolean isContinueOperation = false;
    /**
     * Default constructor.
     * @param calc - Calculator class.
     * @param ioWorker - class for working with Input/Output.
     */
    public InteractCalc(Calculator calc, IOWork ioWorker) {
        this.calc = calc;
        this.ioWorker = ioWorker;
    }

    /**
     * Initiate Interactive Calculator.
     */
    public void init() {
        boolean isExit = false;
        while (!isExit) {
            if (!this.isContinueOperation) {
                this.calc.setResultZero();
            }
                this.nextOperation();
                this.printResult();
                this.isContinueComputing();
            if (!this.isContinueOperation) {
                isExit = this.ioWorker.isExit();
            }
        }
    }
    /**
     * Method for calculation.
     */
    private void nextOperation() {
        double first;
        if (this.isContinueOperation) {
            first = this.calc.getResult();
        } else {
            first = this.ioWorker.inputOperand("Введите первый операнд.");
        }
        String operation = this.ioWorker.inputOperation("Введите символ операции.");
        double second = this.ioWorker.inputOperand("Введите второй операнд.");
        this.calc.doSingleOperation(first, operation, second);
    }

    /**
     * Method prints result of calculation.
     */
    public void printResult() {
        this.ioWorker.printString(String.format("Результат вычислений = %f", this.getResultFromCalc()));
    }

    /**
     * Method return result of calculation.
     * @return result of calculation.
     */
    public double getResultFromCalc() {
        return this.calc.getResult();
    }

    /**
     * Method return user's answer - is need to continue calculation with previous result or not.
     */
    private void isContinueComputing() {
        this.isContinueOperation = this.ioWorker.isContinue();
    }
}