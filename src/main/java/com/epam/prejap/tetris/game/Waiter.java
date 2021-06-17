package com.epam.prejap.tetris.game;

import java.util.concurrent.TimeUnit;

/**
 * Causes delay between game iterations and speeds up game
 *
 * @author Herman Kulik
 */
public class Waiter {
    private final int milliseconds;
    private int adjustment;

    /**
     * Initializes a Waiter with starting delay value in milliseconds
     *
     * @param milliseconds starting value of delay in milliseconds
     */
    public Waiter(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * Provides a delay, making executing thread sleep for preliminary milliseconds quantity, decreased by current adjustment
     * set by {@link #speedTheGame(int)}
     */
    public void waitForIt() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds - adjustment);
        } catch (InterruptedException ignore) {
        }
    }

    /**
     * Increases adjustment in milliseconds by 100 milliseconds every 10 points
     * what leads to delay increase between cycles of the game when {@link #waitForIt()} method is invoked
     *
     * @param score current score of the game
     * @implNote adjustment may be increased only if potentially adjusted delay is higher or equals to 100 milliseconds,
     * as delay cannot be negative
     */
    public void speedTheGame(int score) {
        if ((score % 10) == 0 && (milliseconds - adjustment) >= 100) {
            adjustment += 100;
        }
    }

    /**
     * Returns adjusted delay value in milliseconds
     *
     * @return milliseconds
     */
    int getMilliseconds() {
        return milliseconds - adjustment;
    }
}
