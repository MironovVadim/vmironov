package ru.calculator;

/**
 * Interface for working with IO library and InteractCalc class.
 */
public abstract class IOWork {
    /**
     * Massif with keys of possible operations.
     */
    private String[] commands;

    /**
     * Default constructor.
     * @param commands - massif with keys of commands
     */
    public IOWork(String[] commands) {
        this.commands = commands;
    }

    /**
     * Method check correctness of forPrint what user has wrote.
     * @param forPrint - String for printing in printString(String forPrint) method.
     * @return String representation of forPrint symbol.
     */
    public abstract String inputOperation(String forPrint);

    /**
     * Method check correctness of forPrint what user has wrote.
     * @param forPrint - String for printing in printString(String forPrint) method.
     * @return double representation of forPrint.
     */
    public abstract double inputOperand(String forPrint);

    /**
     * Method check answer of user to continue operation with previous result of Calculator class or not.
     * @return continue operation with previous result of Calculator class or not.
     */
    public abstract boolean isContinue();

    /**
     * Method check answer of user to exit program of not.
     * @return exit program of not.
     */
    public abstract boolean isExit();

    /**
     * Commands getter.
     * @return commands.
     */
    public String[] getCommands() {
        return commands;
    }

    /**
     * Method prints param String.
     * @param forPrint - String for printing to console.
     */
    public void printString(String forPrint) {
        System.out.println(forPrint);
    }
}