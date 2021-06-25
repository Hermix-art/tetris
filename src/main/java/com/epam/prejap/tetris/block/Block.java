package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.logger.Logger;
import com.epam.prejap.tetris.game.Color;

public abstract class Block {
    private static final Logger LOGGER = Logger.getLogger(Block.class);

    private final byte[][] image;
    private final int rows;
    private final int cols;
    Color color = Color.WHITE;

    Block(byte[][] dots) {
        rows = dots.length;
        if (dots.length == 0) {
            LOGGER.error("The image height of a block is 0. The block cannot be created");
            throw new IllegalArgumentException("Image has height equal to 0");
        }
        cols = dots[0].length;
        image = new byte[rows][cols];
        for (int i = 0; i < dots.length; i++) {
            if (dots[i].length != cols) {
                LOGGER.error("The image of a block is not a rectangle. The block cannot be created");
                throw new IllegalArgumentException("Image is not a rectangle");
            }
            for (int j = 0; j < cols; j++) {
                byte dot = dots[i][j];
                if (dot < 0) {
                    LOGGER.error("The dot value for block is less than 0. The block cannot be created");
                    throw new IllegalArgumentException("Invalid dot value");
                }
                if(dot > 0){
                    color = Color.getColorById(dot);
                    image[i][j] = color.id;
                }
            }
        }
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public byte dotAt(int i, int j) {
        return image[i][j];
    }

    public Color color() {
        return color;
    }
}
