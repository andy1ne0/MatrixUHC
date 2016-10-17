package me.andrewpetersen.matrixuhc.api.engine;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */

import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The class that should be extended by any game managers.
 */
@Getter
public abstract class GameManager extends BukkitRunnable {

    private MatrixUHC instance;
    private ArrayList<GameStateBase> gameBases;
    private int currentGameStateIndex = 0;
    private ReentrantLock baseLock = new ReentrantLock();
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
     * Initialize the Game Manager. This should be called in the constructor of the child class.
     */
    public abstract void initialize();

    /**
     * Check whether or not another game state exists.
     *
     * @return True if there are more game states, false if this is not the case.
     */
    public boolean hasNextState() {
        return this.gameBases.size() >= this.currentGameStateIndex + 1;
    }

    /**
     * Get the current game state - effectively a method to simplify the process of getting the game state using the ID.
     *
     * @return The current game state base.
     */
    public GameStateBase getCurrentState() {
        try {
            this.baseLock.lock();
            return this.getGameBases().get(this.getCurrentGameStateIndex());
        } finally {
            this.baseLock.unlock();
        }
    }

    /**
     * The method that is executed when the game should progress to the next state.
     * @throws IllegalStateException If there is no next state.
     */
    public void nextState() {
        try {
            this.baseLock.lock();
            if (this.hasNextState()) {
                this.currentGameStateIndex++;
            } else {
                throw new IllegalStateException("No more states! ");
            }
        } finally {
            this.baseLock.unlock();
        }
    }

    /**
     * Get the next game state base. Make sure to check if there is one first.
     *
     * @return The next game state, if possible.
     * @throws IllegalStateException If there is no next state.
     */
    public GameStateBase getNextState() {
        if (this.hasNextState()) {
            return this.getGameBases().get(this.getCurrentGameStateIndex() + 1);
        } else {
            throw new IllegalStateException("There is no next state to get! ");
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
        if (this.getCurrentState().getStateTime() <= 0) {
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
