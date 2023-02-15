package com.CricketGame.GameOfCricket.service;

import java.util.Random;

public class RandomNumberGenerator extends Random {

    // Class Variable: Only one generator is created by this class
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    /* Private constructor ensures that a RandomNumberGenerator is ONLY
     * acquired through the getInstance method.
     */
    private RandomNumberGenerator(){}

    public static RandomNumberGenerator getInstance(){
        return randomNumberGenerator;
    }
}