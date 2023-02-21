package com.CricketGame.GameOfCricket.service.coinTosser;

import com.CricketGame.GameOfCricket.model.enums.Coin;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.RandomNumberGenerator;

import java.util.Random;

public class CoinTosser {
    private static final Random randomNumberGenerator = RandomNumberGenerator.getInstance();

    public static Coin flip() {
        if (randomNumberGenerator.nextBoolean()) {
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }
}