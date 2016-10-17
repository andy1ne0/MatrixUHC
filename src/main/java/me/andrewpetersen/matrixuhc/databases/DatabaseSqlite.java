package me.andrewpetersen.matrixuhc.databases;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import me.andrewpetersen.matrixuhc.api.storage.MatrixUhcDatabase;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

/**
 * The SQlite implementation of MatrixDatabase.
 */
@Getter
@Setter(AccessLevel.PRIVATE)
public class DatabaseSqlite implements MatrixUhcDatabase {

    private Connection connection;

    private MatrixUHC instance;

    /**
     * The default constructor for the SQlite MatrixDatabase implementation.
     */
    public DatabaseSqlite(MatrixUHC instance) {

        this.setInstance(instance);

        try {
            Class.forName("org.sqlite.JDBC");
            File dbFile = new File(this.getInstance().getDataFolder(), "storage.db");
            File dir = this.getInstance().getDataFolder();

            if (!dir.exists() && !dir.mkdirs()) {
                throw new IOException("Could not create the data folder! ");
            }

            if (!dbFile.exists() && !dbFile.createNewFile()) {
                throw new IOException("The database file could not be created! ");
            }

            this.setConnection(DriverManager.getConnection("jdbc:sqlite:" + dbFile));

        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {

    }

    @Override
    public void disable() {
        try {
            this.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void increaseKills(Player pl, int amount, DatabaseCallback callback) {

    }

    @Override
    public void getKills(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void increaseDeaths(Player pl, int amount) {

    }

    @Override
    public void getDeaths(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void increaseWins(Player pl, int amount) {

    }

    @Override
    public void getWins(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void increaseLosses(Player pl, int amount) {

    }

    @Override
    public void getLosses(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void getKdr(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void deleteStats(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void trySetKillstreak(Player pl, int amount, DatabaseCallback callback) {

    }

    @Override
    public void updatePlayerData(UUID uuid, String name) {

    }
}
