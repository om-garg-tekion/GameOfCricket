package com.CricketGame.GameOfCricket.model;

import java.util.Random;

public class ScorePoints {
    private static final Random random = new Random();

    public static Points scorePoints() {
        int randomNumber = generateRandomNumber();
        Points pointsScored = switch (randomNumber) {
            case 0 -> Points.ZERO;
            case 1 -> Points.ONE;
            case 2 -> Points.TWO;
            case 3 -> Points.THREE;
            case 4 -> Points.FOUR;
            case 5 -> Points.FIVE;
            case 6 -> Points.SIX;
            case 7 -> Points.WICKET;
            default -> null;
        };

        return pointsScored;
    }

    private static int generateRandomNumber(){
        return random.nextInt(8);
    }
}
