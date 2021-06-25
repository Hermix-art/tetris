package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.logger.Logger;
import com.epam.prejap.tetris.game.Color;

/**
 * Generates a "T" block in the Tetris game - when "1" in a byte array is present then a "#" is printed,
 * otherwise a whitespace (" ") is printed.
 * @see com.epam.prejap.tetris.game.Printer#print(int)
 * @author Grzegorz Konopka
 */
final class TBlock extends Block {
    private static final Logger LOGGER = Logger.getLogger(TBlock.class);
    private static final byte COLOR_ID = Color.GREEN.id;
    /**
     * Byte array represents "T" block.
     * In game will be displayed as (between lines):
     *  -------------------
     *      ###
     *       #
     *  -------------------
     */
    private static final byte[][] IMAGE = {
            {COLOR_ID, COLOR_ID, COLOR_ID},
            {0, COLOR_ID, 0}
    };

    TBlock() {
        super(IMAGE);
        LOGGER.trace("{} was created", getClass().getSimpleName());
    }
}
