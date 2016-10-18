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
import me.andrewpetersen.matrixuhc.api.storage.MatrixConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;

/**
 * The main plugin class.
 */
@Getter
public final class MatrixUHC extends JavaPlugin {

    @Getter
    @Setter(AccessLevel.PRIVATE)
    private static MatrixUHC instance;

    @Setter
    private boolean verbose = false;

    @Setter(AccessLevel.PRIVATE)
    private MatrixGame gameEngine;

    @Setter(AccessLevel.PRIVATE)
    private MatrixConfig settingsConfig;

    @Setter(AccessLevel.PRIVATE)
    private MatrixConfig languageFile;

    @Override
    public void onEnable() {
        MatrixUHC.setInstance(this);
        try {
            this.setSettingsConfig(MatrixConfig.createConfiguration("config.yml"));
            this.setLanguageFile(MatrixConfig.createConfiguration("lang.yml"));
        } catch (IOException e) {
            this.getServer().getLogger().log(Level.SEVERE, Strings.VERBOSE_CONSOLE_PREFIX + "Could not create the config and/or language file! Aborting. ");
        }
        this.setGameEngine(new MatrixGame(this, null)); // TODO shouldn't be null! Don't forget later on.
    }

    @Override
    public void onDisable() {

    }

}
