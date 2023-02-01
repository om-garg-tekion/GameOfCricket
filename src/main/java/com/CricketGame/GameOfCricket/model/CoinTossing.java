package com.CricketGame.GameOfCricket.model;

import java.util.Random;

public class CoinTossing {

    private static final Random random = new Random();

    public static Coin flip() {
        if (random.nextBoolean()) {
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }
}