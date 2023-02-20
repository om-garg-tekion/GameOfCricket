package com.CricketGame.GameOfCricket.service.dao_service;

import com.CricketGame.GameOfCricket.model.composite_key.PlayerPrimaryKeyId;
import com.CricketGame.GameOfCricket.model.entities.player.Player;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player){
        return this.playerRepository.save(player);
    }

    public List<Player> savePlayers(List<Player> players){
        return this.playerRepository.saveAll(players);
    }

    public Player findById(long playerId, long teamId, long matchId){ return this.playerRepository.findById(new PlayerPrimaryKeyId(playerId, teamId, matchId)).orElse(null); }
}
