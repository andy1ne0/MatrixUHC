package me.andrewpetersen.matrixuhc.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import me.andrewpetersen.matrixuhc.api.engine.GameManager;
import me.andrewpetersen.matrixuhc.api.engine.GameStateBase;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

/**
 * This event is triggered whenever the current game state changes, *including the first state*.
 */
@RequiredArgsConstructor
@Getter
public class MatrixNextStateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final GameStateBase stateBase;
    private final GameManager gameManager;
    private final MatrixUHC instance;

    /**
     * A method required by Bukkit.
     *
     * @return The handlers for this event.
     */
    public static HandlerList getHandlerList() {
        return MatrixNextStateEvent.handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return MatrixNextStateEvent.handlers;
    }
}
