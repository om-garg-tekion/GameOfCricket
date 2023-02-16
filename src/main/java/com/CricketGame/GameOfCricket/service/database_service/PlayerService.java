package com.CricketGame.GameOfCricket.service.database_service;

import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void savePlayer(Player player){
        this.playerRepository.save(player);
    }
}
