package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.logger.Logger;
import com.epam.prejap.tetris.game.Color;

/**
 *  It creates I block of tetris
 *
 * @author Kanybek Mukalaev
 * @see BlockFeed
 * @see Block
 */
final class IBlock extends Block {
    private static final Logger LOGGER = Logger.getLogger(IBlock.class);
    private static final byte COLOR_ID = Color.PURPLE.id;

    /**
     * Byte array represents "I" block.
     * In game will be displayed as (between lines):
     *  -------------------
     *       #
     *       #
     *       #
     *       #
     *  -------------------
     */
    private static final byte [][] IMAGE = {
            {COLOR_ID},
            {COLOR_ID},
            {COLOR_ID},
            {COLOR_ID},
    };
    public IBlock(){
        super(IMAGE);
        LOGGER.trace("{} was created", getClass().getSimpleName());
    }
}
