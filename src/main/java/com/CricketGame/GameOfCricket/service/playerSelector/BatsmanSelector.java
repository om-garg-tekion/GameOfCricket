package com.CricketGame.GameOfCricket.service.playerSelector;

import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.List;

public class BatsmanSelector {
    public static Player chooseBatsman(List<Player> players, int noOfWickets){
        return players.get(noOfWickets);
    }
}
