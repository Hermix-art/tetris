package com.epam.prejap.tetris.game;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Tests delay changes in {@link Waiter}, depending on the score provided
 *
 * @author Herman Kulik
 */
@Test(groups = "delays")
public class WaiterTest {
    private static int delay;

    @Factory(dataProvider = "dataMethod")
    public WaiterTest(int newDelay) {
        delay = newDelay;
    }

    @Test(dataProvider = "constantDelays")
    public void delayShouldStayTheSame(int score) {
        Waiter waiter = new Waiter(delay);
        waiter.speedTheGame(score);
        assertEquals(waiter.getMilliseconds(), delay, "Game speed should not change if the score is not multiple of 10");
    }

    @Test(dataProvider = "variableDelays")
    public void delayShouldChangeBy100(int score) {
        Waiter waiter = new Waiter(delay);
        waiter.speedTheGame(score);
        assertEquals(waiter.getMilliseconds(), delay - 100, "Game speed should change if the score is multiple of 10");
    }

    /**
     * Helps to initialize delay variable with values (in milliseconds)
     * when WaiterTest object is being constructed
     *
     * @return delay in milliseconds
     */
    @DataProvider
    private static Object[][] dataMethod() {
        return new Object[][]{
                {500},
                {400},
                {300},
                {200},
                {100},
        };
    }

    @DataProvider
    private static Object[][] constantDelays() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {13},
                {21},
                {101},
                {-1},
                {-11},
                {-25},
        };
    }

    @DataProvider
    private static Object[][] variableDelays() {
        return new Object[][]{
                {10},
                {20},
                {30},
                {40},
                {50},
                {60},
                {70},
        };
    }
}
