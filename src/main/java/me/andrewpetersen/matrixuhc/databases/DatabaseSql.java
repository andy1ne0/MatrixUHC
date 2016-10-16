package me.andrewpetersen.matrixuhc.databases;

import me.andrewpetersen.matrixuhc.api.MatrixUhcDatabase;
import org.bukkit.entity.Player;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */
public class DatabaseSql implements MatrixUhcDatabase { // TODO finish the implementation.

    public DatabaseSql(String url, int port, int dbName, String username, String password) {
        // TODO fill in.
    }

    @Override
    public void initialize() {

    }

    @Override
    public void disable() {

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
    public void getKdr(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void deleteStats(Player pl, DatabaseCallback callback) {

    }

    @Override
    public void trySetKillstreak(Player pl, int amount, DatabaseCallback callback) {

    }
}
