package ru.job4j.testtask;

import java.util.Arrays;
import java.util.Scanner;

/**
 * tic tac toe game.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TicTacToeGame {
    /**
     * Scanner for reading players input.
     */
    private Scanner scanner;
    /**
     * Game field.
     */
    private char[][] field;
    /**
     * Symbols of game X and O.
     */
    private char symbol = 'X';
    /**
     * Length of symbols needed to win.
     */
    private int countToWin;

    /**
     * Default constructor.
     * @param size - size of game field.
     * @param countToWin - length of symbols needed to win.
     * @param scanner - Scanner for reading players input.
     */
    public TicTacToeGame(int size, int countToWin, Scanner scanner) {
        this.field = new char[size][size];
        for (char[] line : this.field) {
            Arrays.fill(line, ' ');
        }
        this.countToWin = countToWin;
        this.scanner = scanner;
    }

    /**
     * Start the game. Method checks is player wants to exit the game (readPlayerInput() method).
     * Then method reads players coordinates (getIntegerFormatCoordinates() method),
     * then put symbol in field with specified coordinates (putSymbolInGrid(int, int) method).
     * Then method prints game field (toString() method).
     * Then method check in game field line with the same symbols and needed length to win (isWin() method)
     * and is game field if fully filled (isFullField() method).
     * Then start new cycle with step of second player.
     * if player wrote incorrect data, method catches NumberFormatException and IndexOutOfBoundsException.
     * @exception GridOccupiedException - throws if new symbol occupied not empty grid on field.
     */
    public void start() {
        while (true) {
            try {
                String playerInput = this.readPlayerInput();
                if (playerInput.equalsIgnoreCase("exit")) {
                    System.out.println("Exit the game.");
                    break;
                }
                int[] coordinates = this.getIntegerFormatCoordinates(playerInput);
                putSymbolInGrid(coordinates[0], coordinates[1]);
                System.out.println(this.toString());
                if (isWin()) {
                    if (this.symbol == 'X') {
                        System.out.println("First player win. (X)");
                    } else {
                        System.out.println("Second player win. (O)");
                    }
                    break;
                }
                if (isFullField()) {
                    System.out.println("Field is full, no one wins.");
                    break;
                }
                this.changeSymbol();
            } catch (NumberFormatException e) {
                System.out.println("Wrong data format.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index Out Of Bounds Exception.");
            } catch (GridOccupiedException e) {
                System.out.println("Specified grid is occupied.");
            }
        }
    }

    /**
     * Method reads players input.
     * @return player input.
     */
    private String readPlayerInput() {
        System.out.println("Enter coordinates through a space or 'exit' to stop the game.");
        String playerInput = this.scanner.nextLine();
        return playerInput;
    }

   /**
     * Method parses coordinates of grid.
     * @param coordinates - coordinates if String format.
     * @return massif with x and y coordinates.
     */
   private int[] getIntegerFormatCoordinates(String coordinates) {
       int[] result = new int[2];
       int height = Integer.parseInt(coordinates.substring(0, coordinates.indexOf(" ")));
       int length = Integer.parseInt(coordinates.substring(coordinates.indexOf(" ") + 1));
       result[0] = height;
       result[1] = length;
       return result;
    }

    /**
     * Method puts symbol in specified grid in game field.
     * @param height - y coordinate.
     * @param length - x coordinate.
     * @exception GridOccupiedException throws if specified grid is not empty.
     */
    private void putSymbolInGrid(int height, int length) throws GridOccupiedException {
        if (this.field[height][length] != ' ') {
            throw new GridOccupiedException();
        }
        this.field[height][length] = this.symbol;
    }

    /**
     * Method substitutes X symbol of first player on O symbol of second player and visa versa.
     */
    private void changeSymbol() {
        if (this.symbol == 'O') {
            this.symbol = 'X';
        } else {
            this.symbol = 'O';
        }
    }

    /**
     * Method checks game field at lines of symbols for win.
     * @return is player win.
     */
    private boolean isWin() {
        boolean result = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (this.field[i][j] != ' ') {
                    result = this.isWin(i, j);
                }
                if (result) {
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Method checks grid of game fiend in every possible direction for existence line of symbols for win.
     * @param height - y coordinate.
     * @param length - x coordinate.
     * @return if win line exists.
     */
    private boolean isWin(int height, int length) {
        boolean result = false;
        int leftDistance = length;
        int rightDistance = this.field.length - length;
        int upperDistance = height;
        int lowerDistance = this.field.length - height;
        if (this.countToWin <= upperDistance) {
            result = true;
            for (int currentHeight = height; currentHeight > height - this.countToWin; currentHeight--) {
                if (field[currentHeight][length] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= upperDistance && this.countToWin <= rightDistance) {
            result = true;
            for (int currentHeight = height, currentLength = length; currentHeight > height - this.countToWin; currentHeight--, currentLength++) {
                if (field[currentHeight][currentLength] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= rightDistance) {
            result = true;
            for (int currentLength = length; currentLength < length + this.countToWin; currentLength++) {
                if (field[height][currentLength] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= lowerDistance && this.countToWin <= rightDistance) {
            result = true;
            for (int currentHeight = height, currentLength = length; currentHeight < height + this.countToWin; currentHeight++, currentLength++) {
                if (this.field[currentHeight][currentLength] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= lowerDistance) {
            result = true;
            for (int currentHeight = height; currentHeight < height + this.countToWin; currentHeight++) {
                if (this.field[currentHeight][length] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= lowerDistance && this.countToWin <= leftDistance) {
            result = true;
            for (int currentHeight = height, currentLength = length; currentHeight < height + this.countToWin; currentHeight++, currentLength--) {
                if (this.field[currentHeight][currentLength] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= leftDistance) {
            result = true;
            for (int currentLength = length; currentLength > length - countToWin; currentLength--) {
                if (this.field[height][currentLength] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        if (!result && this.countToWin <= upperDistance && this.countToWin <= leftDistance) {
            result = true;
            for (int currentHeight = height, currentLength = length; currentHeight > height - this.countToWin; currentHeight--, currentLength--) {
                if (field[currentHeight][currentLength] != this.symbol) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Method checks is field fully filled.
     * @return if field has not empty grids.
     */
    private boolean isFullField() {
        boolean result = true;
        for (char[] line : this.field) {
            for (char grid : line) {
                if (grid == ' ') {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------");
        sb.append(System.lineSeparator());
        sb.append("  ");
        for (int gridNumber = 0; gridNumber < field.length; gridNumber++) {
            sb.append(String.format(" %d ", gridNumber));
        }
        sb.append(System.lineSeparator());
        for (int lineNumber = 0; lineNumber < field.length; lineNumber++) {
            sb.append(String.format("%d ", lineNumber));
            for (int grid = 0; grid < field.length; grid++) {
                sb.append(String.format("[%s]", field[lineNumber][grid]));
            }
            sb.append(System.lineSeparator());
        }
        sb.append("---------------------------------------------");
        return sb.toString();
    }
}
