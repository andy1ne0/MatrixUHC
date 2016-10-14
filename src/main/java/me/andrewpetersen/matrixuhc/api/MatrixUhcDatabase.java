package me.andrewpetersen.matrixuhc.api;
/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

import org.bukkit.entity.Player;

/**
 * This is an interface that the different database types should implement, so as to reduce coupling between the server and the database type.
 * All operations should be completed asynchronously, thus the {@link DatabaseCallback} class has been provided.
 */
public interface MatrixUhcDatabase {

    /**
     * Increase the number of kills the player has.
     *
     * @param pl     The player whose stats are being increased.
     * @param amount The number of kills to add to the existing number.
     */
    public void increaseKills(Player pl, int amount, DatabaseCallback callback);

    /**
     * Get the number of kills the player has.
     *
     * @param pl       The player to collect data from.
     * @param callback The callback for once the information is collected.
     */
    public void getKills(Player pl, DatabaseCallback callback);

    /**
     * Increase the number of deaths the player has.
     *
     * @param pl     The player whose stats are being increased.
     * @param amount The number of deaths to add to the existing number.
     */
    public void increaseDeaths(Player pl, int amount);

    /**
     * Get the number of deaths the player has.
     *
     * @param pl       The player to collect data from.
     * @param callback The callback for once the information is collected.
     */
    public void getDeaths(Player pl, DatabaseCallback callback);

    /**
     * Increase the number of wins the player has.
     *
     * @param pl     The player whose stats are being increased.
     * @param amount The number of wins to add to the existing number.
     */
    public void increaseWins(Player pl, int amount);

    /**
     * Get the number of wins the player has.
     *
     * @param pl       The player to collect data from.
     * @param callback The callback for once the information is collected.
     */
    public void getWins(Player pl, DatabaseCallback callback);

    /**
     * Get the number of deaths the player has.
     *
     * @param pl       The player to collect data from.
     * @param callback The callback for once the information is collected.
     */
    public void getKdr(Player pl, DatabaseCallback callback);

    /**
     * The method used to delete all data from a player.
     *
     * @param pl       THe player who needs their stats wiped.
     * @param callback The callback for once the information is collected.
     */
    public void deleteStats(Player pl, DatabaseCallback callback);

    /**
     * Attempt to set the killstreak this player has. If the killstreak in the database was higher, the callback response code will be 1, and 0 if a new record was set.
     *
     * @param pl       The player whose killstreak is being uploaded.
     * @param amount   The size of the killstreak.
     * @param callback The callback for once the information is collected.
     */
    public void trySetKillstreak(Player pl, int amount, DatabaseCallback callback);

    /**
     * This class to be used when a database operation needs to return a value.
     * This doesn't have to be used by every method - only where such a class may be of use, i.e. retrieving data.
     */
    public abstract class DatabaseCallback {
        /**
         * The method called after the database operation has been executed.
         *
         * @param pl       The player the callback is referring to.
         * @param response The response code from the operation. This should be where any statistics are returned, or where any booleans are returned (0 for true, 1 for false).
         */
        public abstract void run(Player pl, int response);
    }

}
