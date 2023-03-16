package com.CricketGame.GameOfCricket.service.factory.playerFactory;

import com.CricketGame.GameOfCricket.model.beans.player.Batsman;
import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerFactoryImp implements PlayerFactory {
    @Autowired
    private PlayerService playerService;

    @Override
    public Player create(long playerId, long teamId, long matchId){

        Player player = playerService.findById(playerId, teamId, matchId).get();
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

        return player;
    }
}
