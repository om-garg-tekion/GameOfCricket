package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.enums.Runs;

import java.util.Random;

public class RunsSelection {
    private static final Random randomNumberGenerator = RandomNumberGenerator.getInstance();

    private static final Runs[] runsArrayForBatsman = {Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.THREE, Runs.THREE, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FIVE, Runs.SIX, Runs.SIX, Runs.SIX, Runs.SIX, Runs.WICKET, Runs.WICKET, Runs.WICKET, Runs.WICKET};

    private static final Runs[] runsArrayForBowler = {Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ZERO, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.ONE, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.TWO, Runs.THREE, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FOUR, Runs.FIVE, Runs.SIX, Runs.SIX, Runs.WICKET, Runs.WICKET, Runs.WICKET, Runs.WICKET, Runs.WICKET, Runs.WICKET, Runs.WICKET, Runs.WICKET};
    public static Runs getRandomRunsForBatsman() {
        int randomIndex = randomNumberGenerator.nextInt(runsArrayForBatsman.length);
        return runsArrayForBatsman[randomIndex];
    }

    public static Runs getRandomRunsForBowler() {
        int randomIndex = randomNumberGenerator.nextInt(runsArrayForBowler.length);
        return runsArrayForBowler[randomIndex];
    }
}
