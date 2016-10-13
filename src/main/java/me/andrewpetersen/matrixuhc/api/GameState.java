package me.andrewpetersen.matrixuhc.api;

/**
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 * <p>
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */
public enum GameState {

    LOBBY, LOADINGMAP, WARMUP, PLAY_NO_PVP, PLAY_PVP, DEATHMATCH_COUNTDOWN, DEATHMATCH, ENDGAME, UNDEFINED;

    public enum JoinStatus {
        NOT_JOINABLE, JOINABLE_WITH_PERMISSION, JOINABLE;
    }

}
