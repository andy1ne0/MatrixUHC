package me.andrewpetersen.matrixuhc.api.events;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * This class should simply serve as a wrapper for the PlayerDeathEvent - however, it is only executed if a player was killed by another player.
 * Therefore, this class should only be used when completing actions relating to the player's killer, i.e. increasing a killstreak.
 */
@RequiredArgsConstructor
public class MatrixPlayerKilledByPlayerEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final PlayerDeathEvent originalEvent;

    private final Player deadPlayer;

    private final Player killer;

    /**
     * A method required by Bukkit.
     *
     * @return The handlers for this event.
     */
    public static HandlerList getHandlerList() {
        return MatrixPlayerKilledByPlayerEvent.handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return MatrixPlayerKilledByPlayerEvent.handlerList;
    }

}
