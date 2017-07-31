/**
* Class for math operations.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

package ru.calculator;

import ru.calculator.operations.AddOperation;
import ru.calculator.operations.DivOperation;
import ru.calculator.operations.MultiplyOperation;
import ru.calculator.operations.SingleOperation;
import ru.calculator.operations.SubstractOperation;



import java.util.ArrayList;
import java.util.List;

/**
* Class for simple math operations with two numbers.
*/
public class Calculator {

    /**
     * All possible operations in this instance.
     */
	private List<SingleOperation> allOperations;

    /**
     * Default constructor. Constructor uses initializeOperations() method
     * to initialize collection with commands.
     */
	public Calculator() {
		allOperations = this.initializeOperations();
	}

	/**
	* result after math operation.
	*/
	private double result;

	/**
	* @return value - result after math operation
	*/
	public double getResult() {
		return result;
	}

    /**
     * Method set a zero in field result.
     */
	public void setResultZero() {
		this.result = 0;
	}

    /**
     * Fill List allOperations by all possible operations.
     * @return List with operations.
     */
	protected List<SingleOperation> initializeOperations() {
		List<SingleOperation> operationList = new ArrayList<>();
		operationList.add(new AddOperation());
		operationList.add(new DivOperation());
		operationList.add(new MultiplyOperation());
		operationList.add(new SubstractOperation());
		return operationList;
	}

    /**
     * Method return all keys from allOperations.
     * @return String[] with keys of operation
     */
	public String[] getAllKeys() {
	    String[] commands = new String[allOperations.size()];
	    for (int i = 0; i < commands.length; i++) {
	        commands[i] = allOperations.get(i).key();
        }
        return commands;
    }

    /**
     * Method execute one of operations with two numbers and write result into fiend this.result.
     * @param first - first number.
     * @param operation - symbol of operations.
     * @param second - second number.
     */
    public void doSingleOperation(double first, String operation, double second) {
	    for (SingleOperation so : allOperations) {
	        if (operation.equals(so.key())) {
	            this.result = so.doOperation(first, second);
	            break;
            }
        }
    }
}