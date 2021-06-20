package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author Radosław Piwowarski
 */
@Test(groups = {"TestPlayfieldAndHumanPlayer"})
public class TestPlayfield {

    BlockFeed feed;
    Printer printer;
    Playfield playfield;
    private static final int rows = 10;
    private static final int cols = 20;
    /*
     * Maximal number of moves depends on block size, but blocks are private fields in @linkPlayField class
     * and therefore its not possible to access and calculate the value.
     */
    private static final int magicNumberOfMoves = cols / 4;

    @BeforeMethod
    public void initializePlayfield() {
        feed = new BlockFeed();
        printer = new Printer(System.out);
        playfield = new Playfield(rows, cols, feed, printer);
    }

    private static Object[][] helpProvider(Move move) {
        return        IntStream.range(1, cols / 4).boxed().map(i -> new Object[]{i, move}).toArray(Object[][]::new);
    }

    @DataProvider
    public Object[][] provideAcceptableMoves() {
        return Stream.of(helpProvider(Move.LEFT), helpProvider(Move.RIGHT)).flatMap(Stream::of).toArray(Object[][]::new);
    }

    /**
     * Tests if calling moving methods let us move the block.
     * Direct call to move block after it touches the wall causes IndexOutOfBoundsException
     * Direct position checking is not possible, grid is private.
     * Because of different size of blocks, check only up to quarter of number of columns
     */
    @Test(dataProvider = "provideAcceptableMoves")
    public void testAcceptableMovement(int move, Move side) {
        playfield.nextBlock();
        boolean moved = false;
        for (int i = 0; i < move; i++) {
            moved = playfield.move(side);
        }
        assertTrue(moved, "Move of %d, to side %s".formatted(move, side));
    }

    /**
     * Check if after moving to the bottom player can still move to left or right
     * Result should be false
     */
    public void testMoveWithMoveToBottom() {
        playfield.nextBlock();
        assertFalse(playfield.move(Move.TO_BOTTOM_NOW));
    }
}
