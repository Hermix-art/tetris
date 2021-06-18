package com.epam.prejap.tetris.player;

import com.epam.prejap.tetris.game.Move;
import org.tinylog.Logger;

import java.util.Optional;
import java.util.Random;

public class RandomPlayer implements Player {

    private final Random random = new Random();

    public RandomPlayer(){
        Logger.trace("New {} is created", getClass().getSimpleName());
    }

    @Override
    public Optional<Move> nextMove() {
        return Optional.of(Move.values()[random.nextInt(Move.values().length - 1)]);
    }

}
