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
 * The deathmatch game state class.
 */
@Getter
public class StatePlayDeathmatch extends GameStateBase implements StateTimeNotifier {

    @Setter(AccessLevel.PRIVATE)
    private MatrixUHC instance;

    /**
     * The default constructor for this class.
     *
     * @param instance   The MatrixUHC plugin instance.
     * @param publicName The public name of this state.
     * @param joinable   The join status of this state.
     * @param chat       Whether the chat is enabled or disabled during this state.
     * @param build      Whether block operations are permitted during this state.
     * @param stateTime  How long this state should run for.
     */
    public StatePlayDeathmatch(MatrixUHC instance, String publicName, GameState.JoinStatus joinable, boolean chat, boolean build, int stateTime) {
        super(publicName, GameState.DEATHMATCH, joinable, true, chat, build, stateTime);
        this.setInstance(instance);
    }

    @Override
    public void trigger() {

    }

    @Override
    public String getTimeWrapperString(String timeUnit, int time) {
        return null; // TODO complete implementation.
    }
}
