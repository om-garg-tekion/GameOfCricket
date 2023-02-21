package com.CricketGame.GameOfCricket.service.daoService;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
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

    public Player findById(Long playerId, Long teamId, Long matchId){ return this.playerRepository.findById(new PlayerKey(playerId, teamId, matchId)).orElse(null); }
}
