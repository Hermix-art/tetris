package com.epam.prejap.tetris.game;

import java.util.concurrent.TimeUnit;

/**
 * Causes delay between game iterations and speeds up the game
 *
 * @author Herman Kulik
 */
public class Waiter {

    private int milliseconds;

    /**
     * Initializes a Waiter with starting delay value in ms
     *
     * @param milliseconds starting value of delay in ms
     */
    public Waiter(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * Provides a delay, making executing thread sleep for a current quantity of milliseconds
     */
    public void waitForIt() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignore) {
        }
    }

    /**
     * Decreases delay between cycles of the game by 100 ms every 10 points
     *
     * @param score current score of the game
     * @implNote delay may be decreased only if current delay is higher or equals to 100 ms, as delay value cannot be negative
     */
    public void speedTheGame(int score) {
        if ((score % 10) == 0 && milliseconds >= 100) {
            milliseconds = milliseconds - 100;
        }
    }

    /**
     * Returns current delay value in ms
     *
     * @return milliseconds
     */
    int getMilliseconds() {
        return milliseconds;
    }
}
