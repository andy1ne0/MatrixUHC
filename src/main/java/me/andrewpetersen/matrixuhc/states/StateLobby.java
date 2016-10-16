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
import me.andrewpetersen.matrixuhc.api.GameState;
import me.andrewpetersen.matrixuhc.api.GameStateBase;
import me.andrewpetersen.matrixuhc.api.StateTimeNotifier;
import org.bukkit.entity.Player;

public class StateLobby extends GameStateBase implements StateTimeNotifier {

    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private MatrixUHC instance;

    private int repeatTime = 0;

    public StateLobby(MatrixUHC instance, String name, int time, boolean chat) {
        super(name, GameState.LOBBY, GameState.JoinStatus.JOINABLE, false, chat, false, time);
        this.setInstance(instance);
    }

    @Override
    public void trigger() {

        this.repeatTime++;
        if (this.repeatTime >= 45) {
            this.repeatTime = 0;
            for (Player pl : this.getInstance().getServer().getOnlinePlayers()) {
                // TODO send the pl a message.
            }
        }
    }

    @Override
    public String getTimeWrapperString(String timeUnit, int time) {

        return null;
    }
}