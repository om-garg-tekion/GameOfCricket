package com.CricketGame.GameOfCricket.service.dataAccessService;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player) {
        return this.playerRepository.save(player);
    }

    public Optional<Player> findById(Long playerId, Long teamId, Long matchId) {
        return this.playerRepository.findById(new PlayerKey(playerId, teamId, matchId));
    }

    public boolean validatePlayer(Long playerId, Long teamId, Long matchId) {
        Optional<Player> player = this.playerRepository.findById(new PlayerKey(playerId, teamId, matchId));
        try{
            if(player.isEmpty()){
                throw new IllegalArgumentException("Error: Player with given id's is not present");
            }
        }catch(Exception e){
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public Optional<List<Player>> getPlayerByName(String name){
        return this.playerRepository.getPlayerByName(name);
    }

    public Optional<Player> getPlayerByBattingOrderNumber(int battingOrderNumber, long teamId){
        return this.playerRepository.getPlayerByBattingOrderNumber(battingOrderNumber, teamId);
    }

}
