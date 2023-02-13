package com.CricketGame.GameOfCricket.service;

import com.github.javafaker.Faker;

public class FakerGenerator extends Faker {
    // Class Variable: Only one generator is created by this class
    private static FakerGenerator instantiateFaker = new FakerGenerator();

    /* Private constructor ensures that a RandomNumberGenerator is ONLY
     * acquired through the getInstance method.
     */
    private FakerGenerator(){}

    public static FakerGenerator getInstance(){
        return instantiateFaker;
    }
}
