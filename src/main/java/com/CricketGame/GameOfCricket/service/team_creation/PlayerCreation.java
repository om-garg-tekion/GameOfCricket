package com.CricketGame.GameOfCricket.service.team_creation;

import com.CricketGame.GameOfCricket.model.entities.Player.Batsman;
import com.CricketGame.GameOfCricket.model.entities.Player.Bowler;
import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;
import com.CricketGame.GameOfCricket.service.singleton_instantiation.FakerGenerator;
import com.github.javafaker.Faker;


public class PlayerCreation {

    public Player create(Long id){

        Player player = AllService.playerService.findById(id);
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

        return player;
    }
}
