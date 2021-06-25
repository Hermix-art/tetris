package com.epam.prejap.tetris.game;

import java.util.concurrent.TimeUnit;

/**
 * Causes the delay between iterations in the game
 */
public class Waiter {
    private final int milliseconds;

    /**
     * Initializes a Waiter with a delay value in milliseconds
     *
     * @param milliseconds value of delay in milliseconds
     */
    public Waiter(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * Provides a delay, making executing thread sleep for milliseconds quantity provided via constructor
     */
    public void waitForIt() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException toBeLogged) {
            //todo  log the exception info
        }
    }

    /**
     * Returns a new Waiter object, initialized with the delay value decreased by 100 ms, if score is multiple of 10
     * otherwise returns the same object
     *
     * @param score current score of the game
     * @return new Waiter object or the same object
     * @implNote new Waiter object may be returned only if current delay value is higher or equals to 100 milliseconds,
     * as delay cannot be negative
     */
    public Waiter speedTheGame(int score) {
        if ((score % 10) == 0 && (milliseconds) >= 100) {
            return new Waiter(milliseconds - 100);
        } else return this;
    }

    /**
     * Returns delay in milliseconds
     *
     * @return milliseconds
     */
    int getMilliseconds() {
        return milliseconds;
    }
}
