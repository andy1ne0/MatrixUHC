package me.andrewpetersen.matrixuhc.states;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import me.andrewpetersen.matrixuhc.api.engine.GameState;
import me.andrewpetersen.matrixuhc.api.engine.GameStateBase;
import me.andrewpetersen.matrixuhc.api.engine.StateTimeNotifier;
import org.bukkit.entity.Player;

/**
 * The Lobby state implementation.
 */
@Getter
public class StateLobby extends GameStateBase implements StateTimeNotifier {

    @Setter(AccessLevel.PRIVATE)
    private MatrixUHC instance;

    private int repeatTime = 0;

    /**
     * The default constructor.
     *
     * @param instance The MatrixUHC plugin instance.
     * @param name     The public name of this state.
     * @param time     The time this state should run for.
     * @param chat     Whether chat is enabled or disabled.
     */
    public StateLobby(MatrixUHC instance, String name, int time, boolean chat) {
        super(name, GameState.LOBBY, GameState.JoinStatus.JOINABLE, false, chat, false, time);
        this.setInstance(instance);
    }

    @Override
    public void decreaseTicks(int amount) {
        // TODO implement (using config settings) a system to prevent the decreasing of time dependent on how many players are online.
    }

    @Override
    public void trigger() {

        this.repeatTime++;
        if (this.repeatTime >= 45) { // TODO this needs to use the config value for the frequency. Can wait until after the config implementation is finiehsed.
            this.repeatTime = 0;
            for (Player pl : this.getInstance().getServer().getOnlinePlayers()) {
                // TODO send the pl a message. Should use the string constant declared in the lang.yml file. 
            }
        }
    }

    @Override
    public String getTimeWrapperString(String timeUnit, int time) {

        return null; // TODO sort out notif times.
    }
}
