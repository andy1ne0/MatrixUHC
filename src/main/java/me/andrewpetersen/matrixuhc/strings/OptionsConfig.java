package me.andrewpetersen.matrixuhc.strings;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

/**
 * An enum that provides an easy way to look up entries in the main settings config, without any possible room for error.
 */
public enum OptionsConfig {

    VERSION("version"),
    GENERAL("general"),
    LOBBY("lobby"),
    LOADINGMAP("loadingmap"),
    WARMUP("warmup"),
    GRACEPERIOD("game_grace_period"),
    PVPPERIOD("game_pvp_period"),
    ENDGAME("endgame");

    private String literalLocation;

    /**
     * The constructor.
     *
     * @param literalLocation The location in the config file this represents.
     *                        This should be directly usable in the {@link org.bukkit.configuration.file.FileConfiguration#get(String)} methods.
     */
    OptionsConfig(String literalLocation) {
        this.literalLocation = literalLocation;
    }

    @Override
    public String toString() {
        return this.literalLocation;
    }

    /**
     * An enum to represent the general category in the main config file.
     */
    public enum General {

        MINIMUM_PLAYERS("minimum_players");

        private String literalLocation;

        /**
         * The constructor.
         *
         * @param literalLocation The sublocation - note that this is appended to "general.", so as to make this more readable.
         */
        General(String literalLocation) {
            this.literalLocation = OptionsConfig.GENERAL + "." + literalLocation;
        }

        @Override
        public String toString() {
            return this.literalLocation;
        }

    }

}
