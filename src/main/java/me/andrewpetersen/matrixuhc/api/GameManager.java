package me.andrewpetersen.matrixuhc.api;

import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 * <p>
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */

/**
 * The class that should be extended by any game managers.
 */
@Getter
public abstract class GameManager extends BukkitRunnable {

    private MatrixUHC instance;
    private ArrayList<GameStateBase> gameBases;
    private int currentGameStateIndex = 0;
    @Setter
    private boolean waiting = false;

    /**
     * The default constructor.
     *
     * @param instance The plugin instance.
     * @param bases    The game bases to be used, in order.
     */
    public GameManager(MatrixUHC instance, ArrayList<GameStateBase> bases) {
        this.instance = instance;
        this.gameBases = bases;
    }

    /**
     * Check whether or not another game state exists.
     *
     * @return True if there are more game states, false if this is not the case.
     */
    public boolean hasNextState() {
        if (this.gameBases.size() >= this.currentGameStateIndex + 1)
            return true;
        return false;
    }

    /**
     * Get the current game state - effectively a method to simplify the process of getting the game state using the ID.
     *
     * @return The current game state base.
     */
    public GameStateBase getCurrentState() {
        return this.getGameBases().get(this.getCurrentGameStateIndex());
    }

    /**
     * The method that is executed when the game should progress to the next state.
     */
    public void nextState() {
        if (this.hasNextState()) {
            this.currentGameStateIndex++;
        } else {
            throw new IllegalStateException("No more states! ");
        }
    }

    /**
     * The method that should be called for any method that *must* be executed (i.e. title bars, etc.).
     */
    public abstract void runEachTick();

    /**
     * The method that is called in the event that no more game states remain to be executed.
     */
    public abstract void noMoreTicks();

    @Override
    public void run() {
        this.runEachTick();
        if (this.isWaiting()) {
            return;
        }
        if (!this.getCurrentState().isTickingState()) {
            if (this.getCurrentState().getStateTime() != 0) {
                this.setWaiting(true);
                this.getCurrentState().trigger();
                this.getCurrentState().setStateTime(0);
                return;
            }
        }
        if (this.getCurrentState().getStateTime() == 0) {
            if (this.hasNextState()) {
                this.nextState();
            } else {
                this.noMoreTicks();
                return;
            }
        }
        this.getCurrentState().trigger();
        this.getCurrentState().decreaseTicks(1);
    }

}
