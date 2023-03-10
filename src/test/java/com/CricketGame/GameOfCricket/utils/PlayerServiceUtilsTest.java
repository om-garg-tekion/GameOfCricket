package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;

import java.util.Optional;

public class PlayerServiceUtilsTest {

    public Player getPlayer(PlayerKey playerKey){
        Player player = new Player();
        player.setId(playerKey.getId());
        player.setTeamId(playerKey.getTeamId());
        player.setMatchId(playerKey.getMatchId());
        return player;
    }

    public Optional<Player> getOptionalPlayer(){
        return Optional.empty();
    }

    public Player getNullPlayer(){
        return null;
    }

}
