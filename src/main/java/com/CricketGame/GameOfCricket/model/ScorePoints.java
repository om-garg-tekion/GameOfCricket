package com.CricketGame.GameOfCricket.model;

import java.util.Random;

public class ScorePoints {
    private static final Random random = new Random();

    public static Points scorePoints() {
        int randomNumber = generateRandomNumber();
        System.out.println(randomNumber);
        Points pointsScored = switch (randomNumber) {
            case 0 -> Points.Zero;
            case 1 -> Points.One;
            case 2 -> Points.Two;
            case 3 -> Points.Three;
            case 4 -> Points.Four;
            case 5 -> Points.Five;
            case 6 -> Points.Six;
            case 7 -> Points.Wicket;
            default -> null;
        };

        return pointsScored;
    }

    private static int generateRandomNumber(){
        return random.nextInt(8);
    }
}
