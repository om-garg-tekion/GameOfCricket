package com.CricketGame.GameOfCricket.service.team_creation;

import com.CricketGame.GameOfCricket.model.entities.player.Batsman;
import com.CricketGame.GameOfCricket.model.entities.player.Bowler;
import com.CricketGame.GameOfCricket.model.entities.player.Player;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;
import org.springframework.stereotype.Service;


@Service
public class PlayerCreation{
    public static Player create(long playerId, long teamId, long matchId){

        Player player = AllService.playerService.findById(playerId, teamId, matchId);
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

        return player;
    }
}
