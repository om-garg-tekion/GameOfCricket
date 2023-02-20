package com.CricketGame.GameOfCricket.service.player_selection;

import com.CricketGame.GameOfCricket.model.entities.Player.Player;

import java.util.List;

public class BatsmanSelection {
    public static Player chooseBatsman(List<Player> players, int noOfWickets){
        return players.get(noOfWickets);
    }
}
