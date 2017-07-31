package ru.job4j.testtask;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 */
public class TicTacToeGameTest {
    /**
     * Test start() method.
     */
    @Test
    public void whenExitTheGameThenGetExitMessage() {
        String exit = "exit";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        ByteArrayInputStream bais = new ByteArrayInputStream(exit.getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        TicTacToeGame game = new TicTacToeGame(3, 3, scanner);

        game.start();

        String result = baos.toString();
        String expected = String.format("Enter coordinates through a space or 'exit' to stop the game.%1$sExit the game.%1$s", System.lineSeparator());
        assertThat(result, is(expected));
    }

    /**
     * Test start() method.
     */
    @Test
    public void whenStartThenGetMessageWithFirstPlayerWin() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("1 0").add("0 0").add("1 1").add("0 2").add("1 2");
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        TicTacToeGame game = new TicTacToeGame(3, 3, scanner);

        StringBuilder sb = new StringBuilder();
        char[][] field = new char[3][3];
        for (char[] line : field) {
            Arrays.fill(line, ' ');
        }
        field[1][0] = 'X';
        this.appendInSb(sb, field);
        field[0][0] = 'O';
        this.appendInSb(sb, field);
        field[1][1] = 'X';
        this.appendInSb(sb, field);
        field[0][2] = 'O';
        this.appendInSb(sb, field);
        field[1][2] = 'X';
        this.appendInSb(sb, field);
        sb.append(String.format("First player win. (X)%s", System.lineSeparator()));

        game.start();

        String expected = sb.toString();
        String result = baos.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test start() method.
     */
    @Test
    public void whenStartThenGetNumberFormatExceptionMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("0 0r").add("exit");
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        TicTacToeGame game = new TicTacToeGame(2, 3, scanner);

        StringJoiner expectedSJ = new StringJoiner(System.lineSeparator());
        String message = "Enter coordinates through a space or 'exit' to stop the game.";
        expectedSJ.add(message).add("Wrong data format.").add(message).add("Exit the game.").add("");

        game.start();

        String expected = expectedSJ.toString();
        String result = baos.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test start() method.
     */
    @Test
    public void whenStartThenGetIndexOutOfBoundExceptionMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("10 10").add("exit");
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        TicTacToeGame game = new TicTacToeGame(2, 3, scanner);

        StringJoiner expectedSJ = new StringJoiner(System.lineSeparator());
        String message = "Enter coordinates through a space or 'exit' to stop the game.";
        expectedSJ.add(message).add("Index Out Of Bounds Exception.").add(message).add("Exit the game.").add("");

        game.start();

        String expected = expectedSJ.toString();
        String result = baos.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test start() method.
     */
    @Test
    public void whenWriteIncorrectDataThenGetMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("0 0").add("0 1").add("1 0").add("1 1");
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        TicTacToeGame game = new TicTacToeGame(2, 3, scanner);

        StringBuilder sb = new StringBuilder();
        char[][] field = new char[2][2];
        for (char[] line : field) {
            Arrays.fill(line, ' ');
        }
        field[0][0] = 'X';
        this.appendInSb(sb, field);
        field[0][1] = 'O';
        this.appendInSb(sb, field);
        field[1][0] = 'X';
        this.appendInSb(sb, field);
        field[1][1] = 'O';
        this.appendInSb(sb, field);
        sb.append(String.format("Field is full, no one wins.%s", System.lineSeparator()));

        game.start();

        String result = baos.toString();
        String expected = sb.toString();
        assertThat(result, is(expected));
    }

    /**
     * Test start() method.
     */
    @Test
    public void whenWriteIncorrectDataThenGetGridOccupiedExceptionMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StringJoiner answers = new StringJoiner(System.lineSeparator());
        answers.add("0 0").add("0 0").add("exit");
        ByteArrayInputStream bais = new ByteArrayInputStream(answers.toString().getBytes());
        Scanner scanner = new Scanner(new InputStreamReader(bais));
        TicTacToeGame game = new TicTacToeGame(2, 3, scanner);

        StringBuilder sb = new StringBuilder();
        char[][] field = new char[2][2];
        for (char[] line : field) {
            Arrays.fill(line, ' ');
        }
        field[0][0] = 'X';
        this.appendInSb(sb, field);
        String message = "Enter coordinates through a space or 'exit' to stop the game.";
        sb.append(String.format("%s%s", message, System.lineSeparator()));
        sb.append(String.format("Specified grid is occupied.%s", System.lineSeparator()));
        sb.append(String.format("%s%s", message, System.lineSeparator()));
        sb.append(String.format("Exit the game.%s", System.lineSeparator()));

        game.start();

        String expected = sb.toString();
        String result = baos.toString();
        assertThat(result, is(expected));
    }

    /**
     * Helper in test TicTacToeGame class method.
     * @param sb - StringBuilder.
     * @param field - game field.
     */
    private void appendInSb(StringBuilder sb, char[][] field) {
        String message = "Enter coordinates through a space or 'exit' to stop the game.";
        sb.append(String.format("%s%s", message, System.lineSeparator()));
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
        sb.append(System.lineSeparator());
    }
}