package me.andrewpetersen.matrixuhc.states;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
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
 * The in-game (PvP) game state.
 */
@Getter
public class StatePlayPvP extends GameStateBase implements StateTimeNotifier {

    @Setter(AccessLevel.PRIVATE)
    private MatrixUHC instance;

    /**
     * The default class constructor.
     *
     * @param instance   The MatrixUHC instance.
     * @param publicName The public name for this game state.
     * @param joinable   The join status of this state.
     * @param pvp        Whether PvP is enabled or disabled during this game state.
     * @param chat       Whether the chat is enabled or disabled during this state.
     * @param stateTime  The time this state should run for.
     */
    public StatePlayPvP(MatrixUHC instance, String publicName, GameState.JoinStatus joinable, boolean pvp, boolean chat, int stateTime) {
        super(publicName, GameState.PLAY_PVP, joinable, pvp, chat, true, stateTime);
        this.setInstance(instance);
    }

    @Override
    public void trigger() {

    }

    @Override
    public String getTimeWrapperString(String timeUnit, int time) {
        return null; // TODO finish implementation.
    }
}
