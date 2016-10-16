package me.andrewpetersen.matrixuhc.api.engine;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */

import me.andrewpetersen.matrixuhc.states.StateLobby;

/**
 * The Game State enum, used to give different sections of the plugin a simple way to store or compare  a game status.
 */
public enum GameState {

    LOBBY(StateLobby.class), LOADINGMAP, WARMUP, PLAY_NO_PVP, PLAY_PVP, DEATHMATCH_COUNTDOWN, DEATHMATCH, ENDGAME, UNDEFINED;

    private Class<? extends GameStateBase> clazz;

    GameState(Class<? extends GameStateBase> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends GameStateBase> getBase() {
        return this.clazz;
    }

    /**
     * An enum which can dictate the join policy on a game.
     */
    public enum JoinStatus {
        NOT_JOINABLE("NO"), JOINABLE_WITH_PERMISSION("PERM"), JOINABLE("YES");

        private String literal;

        JoinStatus(String literal) {
            this.literal = literal;
        }

        public String toString() {
            return this.literal;
        }

    }

}
