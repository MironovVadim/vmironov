package ru.job4j.calculator;

import ru.job4j.calculator.operations.ElevateOperation;
import ru.job4j.calculator.operations.PercentageOperation;
import ru.job4j.calculator.operations.SingleOperation;

import java.util.List;

/**
 * Extended Calcutator with new operations.
 */
public class ExtendedCalculator extends Calculator {
    @Override
    protected List<SingleOperation> initializeOperations() {
        List<SingleOperation> operations = super.initializeOperations();
        operations.add(new ElevateOperation());
        operations.add(new PercentageOperation());
        return operations;
    }
}
