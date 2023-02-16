package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.Player;

import java.util.List;

public class BatsmanSelection {
    public static Player chooseBatsman(List<Player> players, int noOfWickets){
        return players.get(noOfWickets);
    }
}
