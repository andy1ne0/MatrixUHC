package me.andrewpetersen.matrixuhc.databases;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.api.MatrixUhcDatabase;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */


public class DatabaseMySql implements MatrixUhcDatabase { // TODO finish the implementation.

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    HikariDataSource dataSource;

    /**
     * The constructor for the MySql database implementation.
     *
     * @param url      The URL for the SQL connection, for example: "jdbc:mysql://localhost:3306". Note that trailing slashes are automatically removed.
     * @param dbName   The name of the Database, to be appended to the connection URL.
     * @param username The connection username.
     * @param password The connection password.
     */
    public DatabaseMySql(String url, String dbName, String username, String password) {
        HikariConfig config = new HikariConfig();
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        config.setJdbcUrl(url + "/" + dbName);
        config.setUsername(username);
        config.setPassword(password);
        this.setDataSource(new HikariDataSource(config));
    }

    /**
     * This is simply a wrapper for the {@link HikariDataSource#getConnection()} method.
     *
     * @return The database connection.
     */
    private Connection getConnection() throws SQLException {
        return this.getDataSource().getConnection();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void disable() {
        this.getDataSource().close();
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
}
