package com.epam.prejap.tetris.game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * @author Herman Kulik
 */
public class WaiterTest {
    private static final int threshold = 25;
    private static int delay;

    @Factory(dataProvider = "dataMethod")
    public WaiterTest(int newDelay) {
        delay = newDelay;
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

    @Test(timeOut = 500 + threshold)
    public void waiterShouldWaitFor500millisTime() {
        Waiter waiter = new Waiter(500);
        waiter.waitForIt();
    }

    @Test(timeOut = 400 + threshold)
    public void waiterShouldWaitFor400millisTime() {
        Waiter waiter = new Waiter(400);
        waiter.waitForIt();
    }

    @Test(timeOut = threshold)
    public void waiterShouldNotWait() {
        Waiter waiter = new Waiter(0);
        waiter.waitForIt();
    }

    @Test(dataProvider = "constantDelays")
    public void delayShouldStayTheSame(int score, int delayResult) {
        Waiter waiter = new Waiter(delay);
        waiter.speedTheGame(score);
        Assert.assertEquals(waiter.getMilliseconds(), delayResult, "Delay should not decrease if there are no 10 additional points of scores");
    }

    @Test(dataProvider = "variableDelays")
    public void delayShouldChange(int score, int delayResult) {
        Waiter waiter = new Waiter(delay);
        waiter.speedTheGame(score);
        Assert.assertEquals(waiter.getMilliseconds(), delayResult, "Delay should decrease every 10 points of scores");
    }

    @Test
    public void negativeDelayShouldNotThrowException() {
        Waiter waiter = new Waiter(-100);
        waiter.waitForIt();
    }

    @DataProvider
    private static Object[][] constantDelays() {
        return new Object[][]{
                {1, delay},
                {2, delay},
                {3, delay},
                {4, delay},
                {5, delay},
                {6, delay},
                {7, delay},
                {8, delay},
                {9, delay},
                {13, delay},
                {21, delay},
                {101, delay},
                {-1, delay},
                {-11, delay},
                {-25, delay},
        };
    }


    @DataProvider
    public static Object[][] variableDelays() {
        return new Object[][]{
                {10, delay - 100},
                {20, delay - 100},
                {30, delay - 100},
                {40, delay - 100},
                {50, delay - 100},
                {60, delay - 100},
                {70, delay - 100},
        };
    }


}