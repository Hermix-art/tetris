package com.epam.prejap.tetris.game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Tests  {@link Waiter} delays
 *
 * @author Herman Kulik
 */
public class WaiterTest {
    private static final int THRESHOLD = 30;
    private static int delay;

    @Factory(dataProvider = "dataMethod")
    public WaiterTest(int newDelay) {
        delay = newDelay;
    }

    @Test(timeOut = 500 + THRESHOLD, groups = "delays")
    public void waiterShouldWaitFor500millisTime() {
        Waiter waiter = new Waiter(500);
        waiter.waitForIt();
    }

    @Test(timeOut = 400 + THRESHOLD, groups = "delays")
    public void waiterShouldWaitFor400millisTime() {
        Waiter waiter = new Waiter(400);
        waiter.waitForIt();
    }

    @Test(timeOut = THRESHOLD, groups = "delays")
    public void waiterShouldNotWait() {
        Waiter waiter = new Waiter(0);
        waiter.waitForIt();
    }

    @Test(dataProvider = "constantDelays", groups = "delays")
    public void delayShouldStayTheSame(int score) {
        Waiter waiter = new Waiter(delay);
        waiter.speedTheGame(score);
        Assert.assertEquals(waiter.getMilliseconds(), delay, "Delay should not decrease if there are no 10 additional points of scores");
    }

    @Test(groups = {"exceptions","delays"})
    public void negativeDelayShouldNotThrowException() {
        Waiter waiter = new Waiter(-100);
        waiter.waitForIt();
    }

    @Test(dataProvider = "variableDelays", groups = "delays")
    public void delayShouldChangeBy100(int score) {
        Waiter waiter = new Waiter(delay);
        waiter.speedTheGame(score);
        Assert.assertEquals(waiter.getMilliseconds(), delay - 100, "Delay should decrease every 10 points of scores");
    }

    @DataProvider
    public static Object[][] dataMethod() {
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
    public static Object[][] variableDelays() {
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
