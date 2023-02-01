package com.CricketGame.GameOfCricket.model;

import java.util.ArrayList;

public class Team{
    private ArrayList<Player> players;
    private int totalRuns = 0;
    private int wickets = 0;
    private String name;

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
