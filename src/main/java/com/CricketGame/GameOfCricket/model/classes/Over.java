package com.CricketGame.GameOfCricket.model.classes;

import lombok.Data;

import java.util.List;

@Data
public class Over {
    private Player bowler;

    private List<Player> playedBy;

    private List<Player> wickets;

    private int totalRuns;

    private List<Ball> balls;
}
