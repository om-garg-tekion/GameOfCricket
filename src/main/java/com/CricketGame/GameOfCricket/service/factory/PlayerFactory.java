package com.CricketGame.GameOfCricket.service.factory;

import com.CricketGame.GameOfCricket.model.beans.player.Batsman;
import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;
import org.springframework.stereotype.Service;


@Service
public class PlayerFactory {
    public static Player create(long playerId, long teamId, long matchId){

        Player player = AllService.playerService.findById(playerId, teamId, matchId);
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

        return player;
    }
}
