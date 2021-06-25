package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.logger.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Causes the delay between iterations in the game
 */
public class Waiter {
    private static final Logger LOGGER = Logger.getLogger(Waiter.class);
    private final int milliseconds;

    /**
     * Initializes a Waiter with a delay value in milliseconds
     *
     * @param milliseconds value of delay in milliseconds
     */
    public Waiter(int milliseconds) {
        this.milliseconds = milliseconds;
        LOGGER.trace("New {} object is created with a delay of {}ms", getClass().getSimpleName(), milliseconds);
    }

    /**
     * Provides a delay, making executing thread sleep for milliseconds quantity provided via constructor
     */
    public void waitForIt() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignore) {
            LOGGER.trace("The thread will sleep for {} milliseconds", milliseconds);
        }
        LOGGER.trace("Waited {} milliseconds", milliseconds);
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
