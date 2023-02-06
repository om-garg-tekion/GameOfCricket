package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Player;

import java.util.List;

public class GetBatsman {
    public static Player chooseBatsman(List<Player> players, int noOfWickets){
        return players.get(noOfWickets);
    }
}
