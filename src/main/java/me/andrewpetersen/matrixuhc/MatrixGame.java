package me.andrewpetersen.matrixuhc;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */

import me.andrewpetersen.matrixuhc.api.engine.GameManager;
import me.andrewpetersen.matrixuhc.api.engine.GameStateBase;

import java.util.ArrayList;

/**
 * The base class for the Matrix UHC.
 */
public class MatrixGame extends GameManager {

    /**
     * The default constructor.
     *
     * @param instance The plugin instance.
     * @param bases    The game bases to be used, in order.
     */
    public MatrixGame(MatrixUHC instance, ArrayList<GameStateBase> bases) {
        super(instance, bases);
        this.initialize();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void runEachTick() {

    }

    @Override
    public void noMoreTicks() {

    }
}
