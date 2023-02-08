package com.CricketGame.GameOfCricket.service;

import com.github.javafaker.Faker;

public class InstantiateFaker extends Faker {
    // Class Variable: Only one generator is created by this class
    private static InstantiateFaker instantiateFaker = new InstantiateFaker();

    /* Private constructor ensures that a RandomNumberGenerator is ONLY
     * acquired through the getInstance method.
     */
    private InstantiateFaker (){}

    public static InstantiateFaker getInstance(){
        return instantiateFaker;
    }
}
