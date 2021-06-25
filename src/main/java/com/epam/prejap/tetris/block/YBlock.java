package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.logger.Logger;
import com.epam.prejap.tetris.game.Color;

/**
 * Represents Y block in BlockFeed.
 *
 * @author Anna Silenko
 */
final class YBlock extends Block {
    private static final Logger LOGGER = Logger.getLogger(YBlock.class);
    private static final byte COLOR_ID = Color.YELLOW.id;

    /**
     * Byte array represents "Y" block.
     * In game will be displayed as (between lines):
     *  -------------------
     *      # #
     *       #
     *       #
     *  -------------------
     */
    private static final byte[][] IMAGE = {
            {COLOR_ID, 0, COLOR_ID},
            {0, COLOR_ID, 0},
            {0, COLOR_ID, 0}
    };

    public YBlock() {
        super(IMAGE);
        LOGGER.trace("{} was created", getClass().getSimpleName());
    }
}
