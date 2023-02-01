package com.CricketGame.GameOfCricket.model;

import com.CricketGame.GameOfCricket.service.MatchService;

public class Match {
    private Team winner;

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
