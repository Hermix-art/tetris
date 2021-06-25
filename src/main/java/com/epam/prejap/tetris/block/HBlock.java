package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.logger.Logger;
import com.epam.prejap.tetris.game.Color;

/**
 * Implements H shaped block
 * @author Slawomir Kucab
 * @see com.epam.prejap.tetris.game.Printer#print(int)
 */
final class HBlock extends Block{
    private static final Logger LOGGER = Logger.getLogger(HBlock.class);
    private static final byte COLOR_ID = Color.CYAN.id;

    /**
     * Byte array represents "H" block.
     * In game will be displayed as (between lines):
     *  -------------------
     *       # #
     *       ###
     *       # #
     *  -------------------
     */
    private static final byte[][] IMAGE = {
            {COLOR_ID, 0, COLOR_ID},
            {COLOR_ID, COLOR_ID, COLOR_ID},
            {COLOR_ID, 0, COLOR_ID}
    };
    public HBlock(){
        super(IMAGE);
        LOGGER.trace("{} was created", getClass().getSimpleName());
    }
}
