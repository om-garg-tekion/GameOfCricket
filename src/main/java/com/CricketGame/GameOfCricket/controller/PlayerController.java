package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import com.CricketGame.GameOfCricket.service.dao_service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public Player addPlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }

    @PostMapping("/players")
    public List<Player> addPlayer(@RequestBody List<Player> players){
        return playerService.savePlayers(players);
    }

}
