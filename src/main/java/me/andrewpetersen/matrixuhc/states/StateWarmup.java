package me.andrewpetersen.matrixuhc.states;

import me.andrewpetersen.matrixuhc.api.engine.GameState;
import me.andrewpetersen.matrixuhc.api.engine.GameStateBase;
import me.andrewpetersen.matrixuhc.api.engine.StateTimeNotifier;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

/**
 * The warmup state implementation.
 */
public class StateWarmup extends GameStateBase implements StateTimeNotifier {
    public StateWarmup(String publicName, GameState.JoinStatus joinable, boolean chat, boolean build, int stateTime) {
        super(publicName, GameState.WARMUP, joinable, false, chat, build, stateTime);
    }

    @Override
    public void trigger() {

    }

    @Override
    public String getTimeWrapperString(String timeUnit, int time) {
        return null; // TODO sort out the tick times.
    }
}
