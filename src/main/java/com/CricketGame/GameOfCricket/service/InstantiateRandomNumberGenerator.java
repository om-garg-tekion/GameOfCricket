package com.CricketGame.GameOfCricket.service;

import java.util.Random;

public class InstantiateRandomNumberGenerator extends Random {

    // Class Variable: Only one generator is created by this class
    private static InstantiateRandomNumberGenerator randomNumberGenerator = new InstantiateRandomNumberGenerator();

    /* Private constructor ensures that a RandomNumberGenerator is ONLY
     * acquired through the getInstance method.
     */
    private InstantiateRandomNumberGenerator(){}

    public static InstantiateRandomNumberGenerator getInstance(){
        return randomNumberGenerator;
    }
}