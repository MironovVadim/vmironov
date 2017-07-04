package ru.job4j.calculator;

/**
 * Interface for working with IO library and InteractCalc class.
 */
public interface IOWork {

    /**
     * Method check correctness of forPrint what user has wrote.
     * @param forPrint - String for printing in printString(String forPrint) method.
     * @return String representation of forPrint symbol.
     */
    String inputOperation(String forPrint);

    /**
     * Method check correctness of forPrint what user has wrote.
     * @param forPrint - String for printing in printString(String forPrint) method.
     * @return double representation of forPrint.
     */
    double inputOperand(String forPrint);

    /**
     * Method check answer of user to continue operation with previous result of Calculator class or not.
     * @return continue operation with previous result of Calculator class or not.
     */
    boolean isContinue();

    /**
     * Method check answer of user to exit program of not.
     * @return exit program of not.
     */
    boolean isExit();

    /**
     * Method prints param String.
     * @param forPrint - String for printing to console.
     */
    default void printString(String forPrint) {
        System.out.println(forPrint);
    }
}
