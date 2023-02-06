package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.enums.Coin;

import java.util.Random;

public class TossCoin {
    private static final Random randomNumberGenerator = RandomNumberGenerator.getInstance();

    public static Coin flip() {
        if (randomNumberGenerator.nextBoolean()) {
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }
}