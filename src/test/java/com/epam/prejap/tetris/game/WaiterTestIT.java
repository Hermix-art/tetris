package com.epam.prejap.tetris.game;

import org.testng.annotations.Test;

/**
 * Tests if methods are executed within the time provided in {@link Waiter}
 *
 * @author Herman Kulik
 */
@Test(groups = "timeoutPossible")
public class WaiterTestIT {
    private static final int DELAY_500_MS = 500;
    private static final int DELAY_400_MS = 400;
    private static final int DELAY_ZERO = 0;
    private static final int DELAY_NEGATIVE = -100;
    private static final int THRESHOLD = 50;

    @Test(timeOut = DELAY_500_MS + THRESHOLD)
    public void waiterShouldWaitFor500millisTime() {
        Waiter waiter = new Waiter(DELAY_500_MS);
        waiter.waitForIt();
    }

    @Test(timeOut = DELAY_400_MS + THRESHOLD)
    public void waiterShouldWaitFor400millisTime() {
        Waiter waiter = new Waiter(DELAY_400_MS);
        waiter.waitForIt();
    }

    @Test(timeOut = DELAY_ZERO)
    public void waiterShouldNotWait() {
        Waiter waiter = new Waiter(DELAY_ZERO);
        waiter.waitForIt();
    }

    @Test
    public void negativeDelayShouldNotThrowException() {
        Waiter waiter = new Waiter(DELAY_NEGATIVE);
        waiter.waitForIt();
    }
}
