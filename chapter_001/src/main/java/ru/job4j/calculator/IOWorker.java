package ru.job4j.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for working with IO library and InteractCalc class.
 */
public class IOWorker extends IOWork {
    /**
     *
     * Default constructor.
     * @param commands - all commands of Calculator class.
     */
    public IOWorker(String[] commands) {
        super(commands);
    }
    /**
     * BufferedInputReader.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String inputOperation(String forPrint) {
        printString(forPrint);
        String result;
        try {
            result = reader.readLine();
            boolean isOperationExist = false;
            for (String command : this.getCommands()) {
                if (result.equals(command)) {
                    isOperationExist = true;
                    break;
                }
            }
            if (!isOperationExist) {
                throw new IOException();
            }
        } catch (IOException e) {
            printString("Введены некорректные данные. Попробуйте еще раз.");
            result = inputOperation(forPrint);
        }
        return result;
    }

    @Override
    public double inputOperand(String forPrint) {
        printString(forPrint);
        double result = 0;
        try {
            result = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            printString("Введены не корректные данные. Попробуйте еще раз.");
            result = inputOperand(forPrint);
        }
        return result;
    }

    @Override
    public boolean isContinue() {
        printString("Продолжить операции с предыдущим результатом? y/n");
        boolean result = false;
        try {
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("y")) {
                result = true;
            } else if (!answer.equalsIgnoreCase("n")) {
                throw new IOException();
            }
        } catch (IOException e) {
            printString("Введены некорректные данные. Попробуйте еще раз.");
            result = isContinue();
        }
        return result;
    }

    @Override
    public boolean isExit() {
        printString("Закончить операции? y/n");
        boolean result = false;
        try {
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("y")) {
                result = true;
            } else if (!answer.equalsIgnoreCase("n")) {
                throw new IOException();
            }
        } catch (IOException e) {
            printString("Введены некорректные данные. Попробуйте еще раз.");
            result = isExit();
        }
        return result;
    }
}
