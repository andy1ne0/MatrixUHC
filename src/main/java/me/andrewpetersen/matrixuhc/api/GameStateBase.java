package me.andrewpetersen.matrixuhc.api;

/**
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 * <p>
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */

import lombok.Getter;
import lombok.Setter;

/**
 * The class that all game states should implement.
 */
@Getter
public abstract class GameStateBase {

    private final boolean pvp;
    private final boolean chat;
    private final boolean build;
    private String publicName = "Unnamed State";
    private GameState state = GameState.UNDEFINED;
    private boolean tickingState = false;
    private boolean waiting = false;

    @Setter
    private GameState.JoinStatus joinable = GameState.JoinStatus.JOINABLE;

    @Setter
    private int stateTime = 1;

    /**
     * The constructor that should be used for general game states.
     *
     * @param publicName The public name of this game state.
     * @param state      The representing game state.
     * @param joinable   The type of joining allowed in this base.
     * @param pvp        Whether PvP is enabled or not.
     * @param chat       Whether the chat is enabled or not.
     * @param build      Whether placing/breaking blocks is allowed or not.
     * @param stateTime  The time this state should run for (in seconds).
     */
    public GameStateBase(String publicName, GameState state, GameState.JoinStatus joinable, boolean pvp, boolean chat, boolean build, int stateTime) {
        this.publicName = publicName;
        this.state = state;
        this.joinable = joinable;
        this.pvp = pvp;
        this.chat = chat;
        this.build = build;
        this.stateTime = stateTime;
        this.tickingState = true;
    }

    /**
     * The constructor to use if this is not a ticking state. Should be used for things such as loading a map/world.
     *
     * @param publicName The public name of this game state.
     * @param state      The representing game state.
     * @param joinable   The type of joining allowed in this base.
     * @param pvp        Whether PvP is enabled or not.
     * @param chat       Whether the chat is enabled or not.
     * @param build      Whether placing/breaking blocks is allowed or not.
     */
    public GameStateBase(String publicName, GameState state, GameState.JoinStatus joinable, boolean pvp, boolean chat, boolean build) {
        this.publicName = publicName;
        this.state = state;
        this.joinable = joinable;
        this.pvp = pvp;
        this.chat = chat;
        this.build = build;
    }

    /**
     * The method called to lower the number of remaining ticks.
     *
     * @param amount The number of ticks to deduct.
     */
    public void decreaseTicks(int amount) {
        this.setStateTime(this.stateTime - amount);
    }

    /**
     * The method where all repeated logic is executed, or all once-off logic is executed.
     */
    public abstract void trigger();

}
