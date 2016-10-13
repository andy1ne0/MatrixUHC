package me.andrewpetersen.matrixuhc;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared).
 * <p>
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory.
 */
public final class MatrixUHC extends JavaPlugin implements Listener {

    private static MatrixUHC instance;

    public static MatrixUHC getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        instance = this;
    }

    @Override
    public void onDisable() {

    }

}
