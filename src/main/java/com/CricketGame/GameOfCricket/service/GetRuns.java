package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.enums.Runs;

import java.util.Random;

public class GetRuns {
    private static final Random randomNumberGenerator = RandomNumberGenerator.getInstance();

    private static final Runs[] runsArray = {Runs.ZERO, Runs.ONE, Runs.TWO, Runs.THREE, Runs.FOUR, Runs.FIVE, Runs.SIX, Runs.WICKET};

    public static Runs getRandomRuns() {
        int randomIndex = randomNumberGenerator.nextInt(runsArray.length);
        return runsArray[randomIndex];
    }
}
