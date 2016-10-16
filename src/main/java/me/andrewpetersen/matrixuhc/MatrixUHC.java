package me.andrewpetersen.matrixuhc;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main plugin class.
 */
public final class MatrixUHC extends JavaPlugin {

    private static MatrixUHC instance;

    @Getter
    @Setter
    private boolean verbose = false;

    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private MatrixGame gameEngine;

    /**
     * Get the primary plugin instance. This should be avoided - preferably use dependency injection.
     *
     * @return The MatrixUHC instance.
     */
    public static MatrixUHC getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        MatrixUHC.instance = this;
        this.setGameEngine(new MatrixGame(this, null)); // TODO shouldn't be null! Don't forget later on.
    }

    @Override
    public void onDisable() {

    }

}
