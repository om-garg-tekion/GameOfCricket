package com.CricketGame.GameOfCricket.model;

public abstract class Player {
    private int runs = 0;
    private int wickets = 0;

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
