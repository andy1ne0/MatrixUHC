package me.andrewpetersen.matrixuhc.api;/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

public interface StateTimeNotifier {

    /**
     * The method that should return the string to appear if a time were to be picked.
     * If this returns null, no string should be shown.
     *
     * @return The string to be shown (nullable).
     */
    public String getTimeWrapperString(String timeUnit, int time);

}
