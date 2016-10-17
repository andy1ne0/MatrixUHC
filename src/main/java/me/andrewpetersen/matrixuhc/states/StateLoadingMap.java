package me.andrewpetersen.matrixuhc.states;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import me.andrewpetersen.matrixuhc.api.engine.GameState;
import me.andrewpetersen.matrixuhc.api.engine.GameStateBase;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

/**
 * The LoadingMap class.
 */
@Getter
public class StateLoadingMap extends GameStateBase {

    @Setter(AccessLevel.PRIVATE)
    private MatrixUHC instance;

    /**
     * The constructor for the LoadingMap state.
     *
     * @param instance   The MatrixUHC instance.
     * @param publicName The public name of this game state.
     * @param chat       Whether the chat is enabled or disabled during this game state.
     */
    public StateLoadingMap(MatrixUHC instance, String publicName, boolean chat) { // TODO finish this implementation.
        super(publicName, GameState.LOADINGMAP, GameState.JoinStatus.NOT_JOINABLE, false, chat, false);
        this.setInstance(instance);
    }

    @Override
    public void trigger() {

    }
}
