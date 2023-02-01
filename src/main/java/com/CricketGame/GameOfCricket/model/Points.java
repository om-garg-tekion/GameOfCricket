package com.CricketGame.GameOfCricket.model;

public enum Points {
    Zero(0),
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Wicket(7);

    private final int pointScored;
    Points(int points){
        pointScored = points;
    }

    public int getPointScored(){
        return pointScored;
    }
}
