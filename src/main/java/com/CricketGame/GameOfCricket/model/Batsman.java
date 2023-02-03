package com.CricketGame.GameOfCricket.model;

public class Batsman{
    private int totalRunsMade = 0;

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
