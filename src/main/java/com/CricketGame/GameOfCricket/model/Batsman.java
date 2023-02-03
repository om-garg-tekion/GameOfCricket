package com.CricketGame.GameOfCricket.model;

public class Batsman{
    private int totalRunsMade = 0;

    private int totalBallsPlayed = 0;

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public void setTotalBallsPlayed(int totalBallsPlayed) {
        this.totalBallsPlayed = totalBallsPlayed;
    }

    public int getTotalRunsMade() {
        return totalRunsMade;
    }

    public void setTotalRunsMade(int totalRunsMade) {
        this.totalRunsMade = totalRunsMade;
    }

    public Points getRuns(){
        return ScorePoints.scorePoints();
    };
}
