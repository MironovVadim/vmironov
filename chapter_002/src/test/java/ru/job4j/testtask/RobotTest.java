package ru.job4j.testtask;

import org.junit.Test;
import ru.job4j.testtask.Robot;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Robot.
 */
public class RobotTest {
    /**
     * Test start() method.
     */
    @Test
    public void whenStartThenGetTrue() {
        int[][] square = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0}};
        Robot robot = new Robot(square);
        boolean result = robot.start();
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test start() method.
     */
    @Test
    public void whenStartThenGetFalse() {
        int[][] square = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 0}};
        Robot robot = new Robot(square);
        boolean result = robot.start();
        boolean expected = false;
        assertThat(result, is(expected));
    }
}