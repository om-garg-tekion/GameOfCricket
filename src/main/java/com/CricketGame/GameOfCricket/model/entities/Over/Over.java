package com.CricketGame.GameOfCricket.model.entities.Over;

import com.CricketGame.GameOfCricket.model.entities.Bean;
import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import lombok.Data;

import java.util.List;

@Data
public class Over extends Bean {
    private Player bowler;

    private List<Player> playedBy;

    private List<Player> wickets;

    private int totalRuns;

    private List<Ball> balls;
}
