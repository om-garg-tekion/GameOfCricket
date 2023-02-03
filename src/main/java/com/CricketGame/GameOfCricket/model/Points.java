package com.CricketGame.GameOfCricket.model;

public enum Points {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    WICKET(7);

    private final int pointScored;
    Points(int points){
        pointScored = points;
    }

    public int getPointScored(){
        return pointScored;
    }
}
